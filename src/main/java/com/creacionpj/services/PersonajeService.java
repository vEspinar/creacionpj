package com.creacionpj.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.DTO.PersonajeDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.*;
import com.creacionpj.repositories.BagajeRepository;
import com.creacionpj.repositories.ClaseRepository;
import com.creacionpj.repositories.PersonajeRepository;
import com.creacionpj.repositories.RazaRepository;
import com.creacionpj.repositories.SubRazaRepository;
import com.creacionpj.repositories.SubidaNivelRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class PersonajeService {
    
    private final PersonajeRepository pr;
    private final SubidaNivelRepository snr;
    private final ClaseRepository cr;
    private final RazaRepository rr;
    private final SubRazaRepository srr;
    private final BagajeRepository br;
    public PersonajeService(PersonajeRepository pr, SubidaNivelRepository snr, ClaseRepository cr, 
        RazaRepository rr, SubRazaRepository srr, BagajeRepository br){
        this.pr=pr;
        this.snr=snr;
        this.cr=cr;
        this.rr=rr;
        this.srr=srr;
        this.br=br;
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
        Raza raza = rr.findById(ra).orElseThrow(() -> new ResourceNotFoundException(Constants.RAZA_NO_ENCONTRADA));
        SubRaza subraza = srr.findById(sra).orElseThrow(() -> new ResourceNotFoundException(Constants.SUBRAZA_NO_ENCONTRADA));
        Libre libre = new Libre(new ArrayList<>(), new ArrayList<>());
        return PersonajeDTO.from(crearPersonaje(clase, bagaje, raza, subraza, null, libre, 1));
    }

    //Añadir una List de Estadisticas a Libre en función de las opciones que de la clase, raza y bagaje.
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

    public void estadisticasRaza(Raza rz, Libre lb){
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
    public Estadistica calcularEstadisticas(Raza rz, Libre lb){
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
                if(num1>=17){
                    num1+=1;
                }else{
                    num1+=2;
                }
            }
        }else{
            for(int i=num2; i<0; i++){
                if(num1>17){
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
        habs = subirHabilidades(subidas, lvl, libre);       
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
    
    //Calcular la competencia de las habilidades con reglas de límites por nivel.
    public Habilidad subirHabilidades(List<SubidaHabilidad> subidas, int lvl, Libre libre){
        Habilidad habs = new Habilidad();
        for(SubidaHabilidad sh: subidas){
            if((lvl<3 && sh.getValor()>1)||(lvl<7 && sh.getValor()>2)||(lvl<15 && sh.getValor()>3)){
                libre.setTotalOpcionesHab(libre.getTotalOpcionesHab()+1);
            }else{
                switch(sh.getHab()){
                    case ACROBACIAS: habs.setAcrobaciasComp(sh.getValor());
                        break;
                    case ARCANO: habs.setArcanoComp(sh.getValor());
                        break;
                    case ARTESANIA:habs.setArtesaniaComp(sh.getValor());
                        break;
                    case ATLETISMO: habs.setAtletismoComp(sh.getValor());
                        break;
                    case DIPLOMACIA:habs.setDiplomaciaComp(sh.getValor());
                        break;
                    case ENGANO:habs.setEnganoComp(sh.getValor());
                        break;
                    case INTERPRETACION: habs.setInterpretacionComp(sh.getValor());
                        break;
                    case INTIMIDACION:habs.setIntimidacionComp(sh.getValor());
                        break;
                    case LATROCINIO:habs.setLatrocinioComp(sh.getValor());
                        break;
                    case MEDICINA:habs.setMedicinaComp(sh.getValor());
                        break;
                    case NATURALEZA:habs.setNaturalezaComp(sh.getValor());
                        break;
                    case OCULTISMO:habs.setOcultismoComp(sh.getValor());
                        break;
                    case RELIGION:habs.setReligionComp(sh.getValor());
                        break;
                    case SABER:habs.setSaberComp(sh.getValor());
                        break;
                    case SIGILO:habs.setSigiloComp(sh.getValor());
                        break;
                    case SOCIEDAD:habs.setSociedadComp(sh.getValor());
                        break;
                    case SUPERVIVENCIA:habs.setSupervivenciaComp(sh.getValor());
                        break;
                }   
            }
        }
        return habs;
    }

    private int modificador(int puntuacion){return Math.floorDiv(puntuacion-10,2);}
    
    //Creación de personaje. Requiere clase, bagaje, Herencia, subraza y equipo.
    @Transactional
    public Personaje crearPersonaje(Clase cla, Bagaje bag, Raza ra, SubRaza sra, List<Equipo> equ, Libre lib, int lvl){
        if(lvl<=0){lvl=1;}
        if(lib==null){lib=new Libre();}
        if(equ==null){equ=new ArrayList<Equipo>();}
        if(cla==null||bag==null||ra==null||sra==null||sra.getReq()==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(sra.getReq().getRaza()!=ra.getRaza()){throw new BadRequestException(Constants.SUBRAZA_NO_PERTENECE);}
        String nom = "";
        estadisticasClase(cla, lib);
        estadisticasRaza(ra, lib);
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
        pj.setLvl(pj.getLvl()+1);
        pj.setVida(pj.getVida()+modificador(pj.getStats().getConstitucion())+pj.getClase().getVida());
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
                huecosd.add(new HuecoDote(pj, pj.getLvl(),TipoDote.RAZA));
            }
        }
        if(subida.getSubidasComp()!=null){
            for(SubidaCompetenciaCombate scc: subida.getSubidasComp()){
                for(TipoCompetenciaCombate tcc: scc.getComps()){
                switch(tcc){
                    case ARMADURALIGERA: 
                        pj.getComp().setArmaduraLigeraComp(scc.getValor());
                        break;
                    case ARMADURAMEDIA:
                        pj.getComp().setArmaduraMediaComp(scc.getValor());
                        break;
                    case ARMADURAPESADA:
                        pj.getComp().setArmaduraPesadaComp(scc.getValor());
                        break;
                    case ARMASAVANZADAS:
                        pj.getComp().setArmasAvanzadasComp(scc.getValor());
                        break;    
                    case ARMASMARCIALES:
                        pj.getComp().setArmasMarcialesComp(scc.getValor());
                        break;    
                    case ARMASSIMPLES:
                        pj.getComp().setArmasSimplesComp(scc.getValor());
                        break;
                    case PERCEPCION:
                        pj.getComp().setPercepcionComp(scc.getValor());
                        break;
                    case VOLUNTAD:
                        pj.getComp().setVoluntadComp(scc.getValor());
                        break;
                    case SINARMADURA:
                        pj.getComp().setSinArmaduraComp(scc.getValor());
                        break;
                    case SINARMAS:
                        pj.getComp().setSinArmasComp(scc.getValor());
                        break;
                    case REFLEJOS:
                        pj.getComp().setReflejosComp(scc.getValor());
                        break;
                    case FORTALEZA:
                        pj.getComp().setFortalezaComp(scc.getValor());
                        break;
                    case CLASE:
                        pj.getComp().setClaseComp(scc.getValor());
                        break;
                    case CONJURO:
                        pj.getComp().setConjuroComp(scc.getValor());
                        break;
                    }
                }
            }
        }
    return PersonajeDTO.from(pj);        
    }
}
