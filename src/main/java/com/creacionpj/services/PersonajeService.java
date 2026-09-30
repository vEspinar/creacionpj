package com.creacionpj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.DTO.LibreDTO;
import com.creacionpj.DTO.PersonajeDTO;
import com.creacionpj.DTO.SeleccionEstadisticasDTO;
import com.creacionpj.DTO.SeleccionHabilidadesDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.*;
import com.creacionpj.repositories.BagajeRepository;
import com.creacionpj.repositories.ClaseRepository;
import com.creacionpj.repositories.PersonajeRepository;
import com.creacionpj.repositories.AscendenciaRepository;
import com.creacionpj.repositories.HerenciaRepository;
import com.creacionpj.repositories.SubidaNivelRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class PersonajeService {

    private final PersonajeRepository pr;
    private final SubidaNivelRepository snr;
    private final ClaseRepository cr;
    private final AscendenciaRepository rr;
    private final HerenciaRepository srr;
    private final BagajeRepository br;
    private final DoteService ds;

    public PersonajeService(PersonajeRepository pr, SubidaNivelRepository snr, ClaseRepository cr, 
        AscendenciaRepository rr, HerenciaRepository srr, BagajeRepository br, DoteService ds){
        this.pr=pr;
        this.snr=snr;
        this.cr=cr;
        this.rr=rr;
        this.srr=srr;
        this.br=br;
        this.ds=ds;
    }

    public List<PersonajeDTO> findAll(){
        return pr.findAll().stream().map(PersonajeDTO::from).toList();
    }

    public Personaje findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return pr.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.PJ_NO_ENCONTRADO));
    }

    @Transactional (readOnly = true)
    public PersonajeDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return PersonajeDTO.from(pr.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.PJ_NO_ENCONTRADO)));
    }

    @Transactional 
    public PersonajeDTO crearPersonaje(Long cl, Long ba, Long ra, Long sra){
        Clase clase = cr.findById(cl).orElseThrow(() -> new ResourceNotFoundException(Constants.CLASE_NO_ENCONTRADA));
        Bagaje bagaje = br.findById(ba).orElseThrow(() -> new ResourceNotFoundException(Constants.BAGAJE_NO_ENCONTRADO));
        Ascendencia ascendencia = rr.findById(ra).orElseThrow(() -> new ResourceNotFoundException(Constants.ASCENDENCIA_NO_ENCONTRADA));
        Herencia herencia = srr.findById(sra).orElseThrow(() -> new ResourceNotFoundException(Constants.HERENCIA_NO_ENCONTRADA));
        Libre libre = new Libre(new ArrayList<>(), new ArrayList<>());
        return PersonajeDTO.from(crearPersonaje(clase, bagaje, ascendencia, herencia, null, libre, 1));
    }

    //Añadir una List de Estadisticas a Libre en función de las opciones que de la clase, ascendencia y bagaje.
    public void estadisticasClase(Clase cl, Libre lb){
        if(cl==null||lb==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(cl.getOpcionesEstadisticas().size()==1){
            lb.getStats().add(new SubidaEstadistica(cl.getOpcionesEstadisticas().getFirst(),1));
        }else{
            if(lb.getOpcionesStats()==null){
                lb.setOpcionesStats(new ArrayList<>());
            }
            lb.getOpcionesStats().addAll(cl.getOpcionesEstadisticas());
        }
    }

    public void estadisticasAscendencia(Ascendencia rz, Libre lb){
        if(rz==null||lb==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(rz.getStatsLibres()>0){
            lb.setTotalOpcionesStats(lb.getTotalOpcionesStats()+rz.getStatsLibres());
        }
    }

    public void estadisticasBagaje(Bagaje bg, Libre lb){
        if(bg==null||lb==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(lb.getOpcionesStats()==null){
            lb.setOpcionesStats(new ArrayList<>());
        }
        lb.getOpcionesStats().addAll(bg.getOpcionesEstadisticas());
    }

    //Añadir un aList de Habilidades a Libre en función de las opciones que de la clase.
    public void habilidadesClase(Clase cl, Libre lb){
        if(cl==null||lb==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        List<TipoHabilidad> opciones = cl.getOpcionesHabilidad();
        if(opciones.size()==1){
            lb.getSkills().add(new SubidaHabilidad(opciones.getFirst(),1));
        }else{
            if(lb.getOpcionesHabs()==null){lb.setOpcionesHabs(new ArrayList<>());}
            lb.getOpcionesHabs().addAll(opciones);
        }
        lb.setTotalOpcionesHab(lb.getTotalOpcionesHab()+cl.getLibreHabilidad());
    }

    //Calculo de estadisticas en funcion de las listas en libre.
    public Estadistica calcularEstadisticas(Ascendencia rz, Libre lb){
        if(rz==null||lb==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        Estadistica stats= new Estadistica(10, 10, 10, 10, 10, 10);
        List<SubidaEstadistica> subidas = new ArrayList<>();
        subidas.addAll(lb.getStats());
        subidas.addAll(rz.getStats());
        stats = subirEstadisticas(stats, subidas);
        return stats;
    }
    
    //Calculo de las subidas de estadisticas con una lista de Subidas.
    public Estadistica subirEstadisticas(Estadistica stats, List<SubidaEstadistica> subidas){
        if(stats==null||subidas==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        for(SubidaEstadistica se: subidas){
             switch(se.getStatFijo()){
                case FUERZA: stats.setFuerza(calculoEstadistica(stats.getFuerza(),se.getValor()));
                break;
                case DESTREZA: stats.setDestreza(calculoEstadistica(stats.getDestreza(),se.getValor()));
                break;
                case CONSTITUCION: stats.setConstitucion(calculoEstadistica(stats.getConstitucion(),se.getValor()));
                break;
                case INTELIGENCIA: stats.setInteligencia(calculoEstadistica(stats.getInteligencia(),se.getValor()));
                break;
                case SABIDURIA: stats.setSabiduria(calculoEstadistica(stats.getSabiduria(),se.getValor()));
                break;
                case CARISMA: stats.setCarisma(calculoEstadistica(stats.getCarisma(),se.getValor()));
                break;
            }
        }
        return stats;
    }
    
    //Suma de estadisticas en función de las reglas (al llegar a 18 (inclusive), de 1 en 1, antes de 2 en 2)
    public int calculoEstadistica(int num1, int num2){
        if(num2>0){
            for(int i=num2; i>0; i--){
                if(num1>17){
                    num1+=1;
                }else{
                    num1+=2;
                }
            }
        }else{
            for(int i=num2; i<0; i++){
                if(num1>18){
                    num1-=1;
                }else{
                    num1-=2;
                }
            }
        }
        return num1;
    }

    //Calculo de habilidades en función de la clase, bagaje, dotes, libre y nivel.
    public Habilidad calcularHabilidades(Clase clase, Bagaje bagaje, Dote dote, Libre libre, int lvl){
        Habilidad habs = new Habilidad();
        List<SubidaHabilidad> subidas = new ArrayList<>();
        habilidadesClase(clase, libre);
        subidas = anadirHabilidades(subidas, bagaje.getHabilidades(), libre, lvl);
        subidas = anadirHabilidades(subidas, libre.getSkills(), libre,lvl);
        habs = subirHabilidades(habs, subidas, lvl, libre);       
        return habs;
    }

    //Comprovación para las habilidades: No repetir habilidades que no puedan subir de competencia por el nivel del pj.
    //En caso de repetir una habilidad que no puede subir por el nivel, añadir una nueva opción a libre.
    public List<SubidaHabilidad> anadirHabilidades(List<SubidaHabilidad> hab1, List<SubidaHabilidad>hab2, Libre libre, int lvl){
        for(SubidaHabilidad sh: hab2){
            boolean existe = hab1.stream().anyMatch(h->h.getHab().equals(sh.getHab()));
            if(existe){
                if(lvl<3 || (lvl<7 && sh.getValor()>1) || (lvl<15 && sh.getValor()>2)|| sh.getValor()>3){
                    libre.setTotalOpcionesHab(libre.getTotalOpcionesHab()+1);
                }
            }else{
                hab1.add(sh);
            }
        }
        return hab1;
    }
    public int getValorHabilidad(Habilidad hab, TipoHabilidad th){
        int result=0;
        switch(th){
            case ACROBACIAS: result =hab.getAcrobaciasComp();
                        break;
                    case ARCANO: result =hab.getArcanoComp();
                        break;
                    case ARTESANIA:result =hab.getArtesaniaComp();
                        break;
                    case ATLETISMO:result =  hab.getAtletismoComp();
                        break;
                    case DIPLOMACIA:result = hab.getDiplomaciaComp();
                        break;
                    case ENGANO:result = hab.getEnganoComp();
                        break;
                    case INTERPRETACION:result =  hab.getInterpretacionComp();
                        break;
                    case INTIMIDACION:result = hab.getIntimidacionComp();
                        break;
                    case LATROCINIO:result = hab.getLatrocinioComp();
                        break;
                    case MEDICINA:result = hab.getMedicinaComp();
                        break;
                    case NATURALEZA:result = hab.getNaturalezaComp();
                        break;
                    case OCULTISMO:result = hab.getOcultismoComp();
                        break;
                    case RELIGION:result = hab.getReligionComp();
                        break;
                    case SABER:result = hab.getSaberComp();
                        break;
                    case SIGILO:result = hab.getSigiloComp();
                        break;
                    case SOCIEDAD:result = hab.getSociedadComp();
                        break;
                    case SUPERVIVENCIA:result = hab.getSupervivenciaComp();
                        break;
        }
        return result;
    }
    //Reglas de limite de competencia de habilidades por nivel
    public boolean habilidadCapada(Habilidad hab, SubidaHabilidad sh,int lvl){
        int i = getValorHabilidad(hab, sh.getHab())+sh.getValor();
        return (lvl<3 && i>1)||(lvl<7 && i>2)||(lvl<15 && i>3);
    }
    //Calcular la competencia de las habilidades con reglas de límites por nivel.
    public Habilidad subirHabilidades(Habilidad hab, List<SubidaHabilidad> subidas, int lvl, Libre libre){
        for(SubidaHabilidad sh: subidas){
            if(sh.getValor()>0&&habilidadCapada(hab, sh,lvl)){
                libre.setTotalOpcionesHab(libre.getTotalOpcionesHab()+1);
            }else{
                switch(sh.getHab()){
                    case ACROBACIAS: hab.setAcrobaciasComp(hab.getAcrobaciasComp()+sh.getValor());
                        break;
                    case ARCANO: hab.setArcanoComp(hab.getArcanoComp()+sh.getValor());
                        break;
                    case ARTESANIA:hab.setArtesaniaComp(hab.getArtesaniaComp()+sh.getValor());
                        break;
                    case ATLETISMO: hab.setAtletismoComp(hab.getAtletismoComp()+sh.getValor());
                        break;
                    case DIPLOMACIA:hab.setDiplomaciaComp(hab.getDiplomaciaComp()+sh.getValor());
                        break;
                    case ENGANO:hab.setEnganoComp(hab.getEnganoComp()+sh.getValor());
                        break;
                    case INTERPRETACION: hab.setInterpretacionComp(hab.getInterpretacionComp()+sh.getValor());
                        break;
                    case INTIMIDACION:hab.setIntimidacionComp(hab.getIntimidacionComp()+sh.getValor());
                        break;
                    case LATROCINIO:hab.setLatrocinioComp(hab.getLatrocinioComp()+sh.getValor());
                        break;
                    case MEDICINA:hab.setMedicinaComp(hab.getMedicinaComp()+sh.getValor());
                        break;
                    case NATURALEZA:hab.setNaturalezaComp(hab.getNaturalezaComp()+sh.getValor());
                        break;
                    case OCULTISMO:hab.setOcultismoComp(hab.getOcultismoComp()+sh.getValor());
                        break;
                    case RELIGION:hab.setReligionComp(hab.getReligionComp()+sh.getValor());
                        break;
                    case SABER:hab.setSaberComp(hab.getSaberComp()+sh.getValor());
                        break;
                    case SIGILO:hab.setSigiloComp(hab.getSigiloComp()+sh.getValor());
                        break;
                    case SOCIEDAD:hab.setSociedadComp(hab.getSociedadComp()+sh.getValor());
                        break;
                    case SUPERVIVENCIA:hab.setSupervivenciaComp(hab.getSupervivenciaComp()+sh.getValor());
                        break;
                }   
            }
        }
        return hab;
    }

    private int modificador(int puntuacion){return Math.floorDiv(puntuacion-10,2);}
    
    //Creación de personaje. Requiere clase, bagaje, ascendencia, herencia y equipo.
    @Transactional
    public Personaje crearPersonaje(Clase cla, Bagaje bag, Ascendencia ra, Herencia sra, List<Equipo> equ, Libre lib, int lvl){
        if(lvl<=0){lvl=1;}
        if(lib==null){lib=new Libre();}
        if(equ==null){equ=new ArrayList<Equipo>();}
        if(cla==null||bag==null||ra==null||sra==null||sra.getReq()==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(sra.getReq().getAscendencia()!=ra.getAscendencia()){throw new BadRequestException(Constants.HERENCIA_NO_PERTENECE);}
        String nom = "";
        estadisticasClase(cla, lib);
        estadisticasAscendencia(ra, lib);
        estadisticasBagaje(bag, lib);
        Habilidad hab = calcularHabilidades(cla, bag, null, lib, lvl);
        Estadistica stats = calcularEstadisticas(ra, lib);
        CompetenciaCombate comp = cla.getCompBase().clone();
        List<HuecoDote> dotes = new ArrayList<>();
        Personaje pj = new Personaje(nom, cla, bag, equ,ra,sra,lib,hab, stats,comp, dotes);
        pj.setVida(cla.getVida()+ra.getVida()+modificador(stats.getConstitucion()));
        pr.save(pj);
        return pj;
    }

    @Transactional
    public PersonajeDTO subidaNivel(Long id){
        Personaje pj = findById(id);
        if(pj.getLvl()>=20){throw new BadRequestException(Constants.NIVEL_MAXIMO_ALCANZADO);}
        pj.setLvl(pj.getLvl()+1);
        pj.setVida(cambioVida(pj));
        SubidaNivel subida = snr.findByClaseAndLvl(pj.getClase(),pj.getLvl());
        if(subida == null){
            throw new ResourceNotFoundException(Constants.SUBIDA_NO_ENCONTRADA+pj.getLvl()+pj.getClase().getClase());
        }
        pj.getLibre().setTotalOpcionesHab(pj.getLibre().getTotalOpcionesHab()+subida.getCantidadHabilidades());
        pj.getLibre().setTotalOpcionesStats(pj.getLibre().getTotalOpcionesStats()+subida.getCantidadStats());
        List<HuecoDote> huecosd=pj.getHuecosDotes();
        if(subida.getCantidadDotesC()>0){
            for(int i=0; i<subida.getCantidadDotesC(); i++){
                huecosd.add(new HuecoDote(pj, pj.getLvl(),TipoDote.CLASE));
            }
        }
        if(subida.getCantidadDotesG()>0){
            for(int i=0; i<subida.getCantidadDotesG(); i++){
                huecosd.add(new HuecoDote(pj, pj.getLvl(),TipoDote.GENERAL));
            }
        }
        if(subida.getCantidadDotesH()>0){
            for(int i=0; i<subida.getCantidadDotesH(); i++){
                huecosd.add(new HuecoDote(pj, pj.getLvl(),TipoDote.HABILIDAD));
            }
        }
        if(subida.getCantidadDotesR()>0){
            for(int i=0; i<subida.getCantidadDotesR(); i++){
                huecosd.add(new HuecoDote(pj, pj.getLvl(),TipoDote.ASCENDENCIA));
            }
        }
        if(subida.getSubidasComp()!=null){
            subidaComp(id, subida.getSubidasComp());
            
        }
        return PersonajeDTO.from(pj);        
    }

    @Transactional 
    public PersonajeDTO bajadaNivel(Long id){
        Personaje pj = findById(id);
        if(pj.getLvl()<=1){throw new BadRequestException(Constants.NIVEL_MINIMO_ALCANZADO);}
        Libre l= pj.getLibre();
        List<EleccionHabs> eh = l.getEleccionHabs();
        List<EleccionStats> es = l.getEleccionStats();
        List<SubidaHabilidad> bajadaHabilidades = new ArrayList<>();
        SubidaNivel subidaNivel = snr.findByClaseAndLvl(pj.getClase(), pj.getLvl());
        pj.setLvl(pj.getLvl()-1);
        l.setTotalOpcionesStats(l.getTotalOpcionesStats()-subidaNivel.getCantidadStats());
        l.setTotalOpcionesHab(l.getTotalOpcionesHab()-subidaNivel.getCantidadHabilidades());
        for(EleccionHabs hab : eh){
            if(hab.getLvl()==(pj.getLvl()+1)){
                bajadaHabilidades.add(new SubidaHabilidad(hab.getHab(), -1));
            }
        }
        pj.setHab(subirHabilidades(pj.getHab(),bajadaHabilidades, pj.getLvl(), l));
        List<SubidaEstadistica> bajadaEstadisticas = new ArrayList<>();
        for(EleccionStats stat : es){
            if(stat.getLvl()==(pj.getLvl()+1)){
                bajadaEstadisticas.add(new SubidaEstadistica(stat.getStat(),-1));
            }
        }
        pj.setStats(subirEstadisticas(pj.getStats(), bajadaEstadisticas));
        pj.getLibre().getEleccionHabs().removeIf(h -> h.getLvl()==(pj.getLvl()+1));
        pj.getLibre().getEleccionStats().removeIf(s ->s.getLvl()==(pj.getLvl()+1));
        pj.getHuecosDotes().removeIf(d -> d.getNivel()==(pj.getLvl()+1));
        if(subidaNivel.getSubidasComp()!=null){
            List<SubidaCompetenciaCombate> scc = subidaNivel.getSubidasComp().stream().map(s-> new SubidaCompetenciaCombate(s.getComps(), -s.getValor())).toList();
            subidaComp(id,scc);
        }
        pj.setVida(cambioVida(pj));
        pj.setLibre(l);
        return PersonajeDTO.from(pj);
    }

    @Transactional
    public int cambioVida(Personaje pj){
        int vidaMinima = Math.max(1, modificador(pj.getStats().getConstitucion())+pj.getClase().getVida());
        return pj.getAscendencia().getVida()+(vidaMinima*pj.getLvl());
    }

    @Transactional 
    public Personaje setNivel(Long id, int nivel){
        Personaje pj = findById(id);
        if(nivel<=0 || pj.getLvl()>=nivel){throw new BadRequestException(Constants.NIVEL_FUERA_RANGO);}
        if(pj.getLvl()>=20|| nivel>20){throw new BadRequestException(Constants.NIVEL_MAXIMO_ALCANZADO);}
        nivel -= pj.getLvl();
        for(int i =0; i<nivel; i++){
            subidaNivel(id);
        }
        return pj;

    }

    @Transactional 
    public PersonajeDTO selectHabsLibre(Long id, SeleccionHabilidadesDTO habs){
    if(id==null||habs==null||habs.hab()==null){throw new ResourceNotFoundException(Constants.ENTRADA_VACIA);}
        Personaje pj = findById(id);
        return seleccionaHabs(pj, habs);
    }
    @Transactional
    public PersonajeDTO seleccionaHabs(Personaje pj, SeleccionHabilidadesDTO habs){
        Libre l = pj.getLibre();
        List<TipoHabilidad> opcionesHabs = l.getOpcionesHabs();
        int totalOpciones = l.getTotalOpcionesHab();
        List<TipoHabilidad> listaLimpia = new ArrayList<>();
        for(TipoHabilidad hab : habs.hab()){
            if(listaLimpia.contains(hab)){throw new BadRequestException(Constants.HABILIDADES_REPETIDAS);                
            }else{listaLimpia.add(hab);}
        }
        if(opcionesHabs!=null){
            for(TipoHabilidad hab:habs.hab()){
                if(!opcionesHabs.contains(hab)){throw new BadRequestException(Constants.HABILIDADES_NO_PERMITIDAS);}
            }
        }
        if(habs.hab().size()>totalOpciones){throw new BadRequestException(Constants.HABILIDADES_EXCESIVAS);}
        List<EleccionHabs> eleccionHabs = new ArrayList<>();
        if(l.getEleccionHabs()==null){l.setEleccionHabs(new ArrayList<>());}
        List<SubidaHabilidad> sh = new ArrayList<>();
        for(TipoHabilidad hab:listaLimpia){
            EleccionHabs eh = new EleccionHabs(hab, pj.getLvl());
            eh.setLibre(l);
            eleccionHabs.add(eh);
            sh.add(new SubidaHabilidad(hab, 1));
        }
        l.setTotalOpcionesHab(totalOpciones-habs.hab().size());
        l.getEleccionHabs().addAll(eleccionHabs);
        pj.setHab(subirHabilidades(pj.getHab(), sh, pj.getLvl(), l));
        pj.setLibre(l);
        return PersonajeDTO.from(pj);
    }

    @Transactional 
    public PersonajeDTO selectStatsLibre(Long id, SeleccionEstadisticasDTO stats) {
        if(id==null||stats==null||stats.stats()==null){throw new ResourceNotFoundException(Constants.ENTRADA_VACIA);}
        Personaje pj = findById(id);
        return seleccionaStats(pj, stats);
    }
    
    @Transactional
    public PersonajeDTO seleccionaStats(Personaje pj, SeleccionEstadisticasDTO stats){
        Libre l = pj.getLibre();
        List<TipoEstadistica> opcionesStats = l.getOpcionesStats();
        int totalOpciones = l.getTotalOpcionesStats();
        List<TipoEstadistica> listaLimpia = new ArrayList<>();
        for(TipoEstadistica stat : stats.stats()){
            if(listaLimpia.contains(stat)){
                throw new BadRequestException(Constants.ESTADISTICAS_REPETIDAS);
            }else{listaLimpia.add(stat);}
        }
        if(opcionesStats!=null){
            for(TipoEstadistica stat : stats.stats()){
                if(!opcionesStats.contains(stat)){throw new BadRequestException(Constants.ESTADISTICAS_NO_PERMITIDAS);}
            }
        }
        if(stats.stats().size()>totalOpciones){throw new BadRequestException(Constants.ESTADISTICAS_EXCESIVAS);}
        List<EleccionStats> eleccionStats = new ArrayList<>();
        if(l.getEleccionStats()==null){l.setEleccionStats(new ArrayList<>());}
        List<SubidaEstadistica> se = new ArrayList<>();
        for(TipoEstadistica stat:listaLimpia){
            EleccionStats es = new EleccionStats(stat, pj.getLvl());
            es.setLibre(l);
            eleccionStats.add(es);
            se.add(new SubidaEstadistica(es.getStat(),1));
        }
        l.setTotalOpcionesStats(totalOpciones-stats.stats().size());
        l.getEleccionStats().addAll(eleccionStats);
        pj.setStats(subirEstadisticas(pj.getStats(), se));
        pj.setLibre(l);
        return PersonajeDTO.from(pj);
    }

    public LibreDTO showLibre(Long id) {
        Personaje pj = findById(id);
        Libre l = pj.getLibre();
        return new LibreDTO(l.getId(), l.getOpcionesHabs(), l.getOpcionesStats(), l.getTotalOpcionesHab(), l.getTotalOpcionesStats());
    }

    @Transactional 
    public PersonajeDTO selectDote(Long id, Long huecoId, Long doteId){
        if(id==null||huecoId==null||doteId==null){throw new ResourceNotFoundException(Constants.ENTRADA_VACIA);}
        Personaje pj = findById(id);
        Dote dote = ds.findById(doteId);
        return aplicarDoteSelect(pj, huecoId, dote);
    }

    @Transactional 
    public PersonajeDTO aplicarDoteSelect(Personaje pj, Long huecoId, Dote dote){
        HuecoDote hd = pj.getHuecosDotes().stream().filter(h-> h.getId().equals(huecoId)).findFirst().orElseThrow(()->new ResourceNotFoundException(Constants.HUECO_NO_ENCONTRADO));
        if(hd.getDote()!=null){throw new BadRequestException(Constants.HUECO_DOTE_EN_USO);}
        if(hd.getTipo()!=dote.getTipoDote()){throw new BadRequestException(Constants.DOTE_TIPO_INCORRECTO);}
        if(!ds.cumpleRequisitos(dote,pj)){throw new BadRequestException(Constants.DOTE_REQUISITO_NO_CUMPLIDO);}
        hd.setDote(dote);
        return PersonajeDTO.from(pj);
    }


    public void subidaComp(Long id, List<SubidaCompetenciaCombate> subida){
        Personaje pj=findById(id);
        for(SubidaCompetenciaCombate scc:subida){
            for(TipoCompetenciaCombate tcc: scc.getComps()){
                switch(tcc){
                    case ARMADURALIGERA: 
                        pj.getComp().setArmaduraLigeraComp(pj.getComp().getArmaduraLigeraComp()+scc.getValor());
                        break;
                    case ARMADURAMEDIA:
                        pj.getComp().setArmaduraMediaComp(pj.getComp().getArmaduraMediaComp()+scc.getValor());
                        break;
                    case ARMADURAPESADA:
                        pj.getComp().setArmaduraPesadaComp(pj.getComp().getArmaduraPesadaComp()+scc.getValor());
                        break;
                    case ARMASAVANZADAS:
                        pj.getComp().setArmasAvanzadasComp(pj.getComp().getArmasAvanzadasComp()+scc.getValor());
                        break;    
                    case ARMASMARCIALES:
                        pj.getComp().setArmasMarcialesComp(pj.getComp().getArmasMarcialesComp()+scc.getValor());
                        break;    
                    case ARMASSIMPLES:
                        pj.getComp().setArmasSimplesComp(pj.getComp().getArmasSimplesComp()+scc.getValor());
                        break;
                    case PERCEPCION:
                        pj.getComp().setPercepcionComp(pj.getComp().getPercepcionComp()+scc.getValor());
                        break;
                    case VOLUNTAD:
                        pj.getComp().setVoluntadComp(pj.getComp().getVoluntadComp()+scc.getValor());
                        break;
                    case SINARMADURA:
                        pj.getComp().setSinArmaduraComp(pj.getComp().getSinArmaduraComp()+scc.getValor());
                        break;
                    case SINARMAS:
                        pj.getComp().setSinArmasComp(pj.getComp().getSinArmasComp()+scc.getValor());
                        break;
                    case REFLEJOS:
                        pj.getComp().setReflejosComp(pj.getComp().getReflejosComp()+scc.getValor());
                        break;
                    case FORTALEZA:
                        pj.getComp().setFortalezaComp(pj.getComp().getFortalezaComp()+scc.getValor());
                        break;
                    case CLASE:
                        pj.getComp().setClaseComp(pj.getComp().getClaseComp()+scc.getValor());
                        break;
                    case CONJURO:
                        pj.getComp().setConjuroComp(pj.getComp().getConjuroComp()+scc.getValor());
                        break;
                }
            }
        }    
    }

}