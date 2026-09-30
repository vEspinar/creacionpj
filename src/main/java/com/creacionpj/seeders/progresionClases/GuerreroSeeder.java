package com.creacionpj.seeders.progresionClases;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.creacionpj.model.Clase;
import com.creacionpj.model.Modificador;
import com.creacionpj.model.SubidaCompetenciaCombate;
import com.creacionpj.model.SubidaNivel;
import com.creacionpj.model.TipoClase;
import com.creacionpj.model.TipoCompetenciaCombate;
import com.creacionpj.model.TipoModificador;
import com.creacionpj.repositories.ClaseRepository;
import com.creacionpj.repositories.SubidaNivelRepository;
import com.creacionpj.utils.Constants;

@Component 
public class GuerreroSeeder implements ProgresionClasesSeeder{
     private static final Logger log = LoggerFactory.getLogger(GuerreroSeeder.class);
  
    private final SubidaNivelRepository snr;
    private final ClaseRepository cr;
    public GuerreroSeeder(SubidaNivelRepository snr, ClaseRepository cr){
        this.snr=snr;
        this.cr=cr;
    }
    
    @Override 
    public TipoClase getTipoClase(){
        return TipoClase.GUERRERO;
    }
    
    @Override 
    public void cargarSubidaNivel(){
        Clase cl = cr.findByClase(TipoClase.GUERRERO);
        if(cl==null){
            log.warn(Constants.CLASE_NO_ENCONTRADA); 
            return;
        }
        if(snr.existsByClase(cl)){
            log.error(Constants.SUBIDA_NIVEL_YA_EXISTE);
            return;
        }
        
        List<SubidaNivel> subidas = new ArrayList<>();
        
        SubidaNivel sn2 = new SubidaNivel(2,cl);
        sn2.setCantidadDotesC(1);
        sn2.setCantidadDotesH(1);
        subidas.add(sn2);

        SubidaNivel sn3= new SubidaNivel(3,cl);
        sn3.setCantidadDotesG(1);
        sn3.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.VOLUNTAD),1)));
        subidas.add(sn3);

        SubidaNivel sn4= new SubidaNivel(4,cl);
        sn4.setCantidadDotesH(1);
        sn4.setCantidadDotesC(1);
        subidas.add(sn4);

        SubidaNivel sn5= new SubidaNivel(5,cl);
        sn5.setCantidadDotesR(1);
        sn5.setCantidadDotesG(1);
        sn5.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMASSIMPLES, TipoCompetenciaCombate.SINARMAS),1)));
        sn5.setCantidadComp(1); //SUBIDA A EXPERTO EN 1 TIPO DE ARMA
        sn5.setCantidadStats(4);
        subidas.add(sn5);

        SubidaNivel sn6= new SubidaNivel(6,cl);
        sn6.setCantidadDotesH(1);
        sn6.setCantidadDotesC(1);
        subidas.add(sn6);
        
        SubidaNivel sn7= new SubidaNivel(7,cl);
        sn7.setOtros(List.of("+2 de daño con armas en las que eres experto. +3 en maestro. +4 en legendario.","+2 a la iniciativa por circunstancia."));
        sn7.setCantidadDotesG(1);
        sn7.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.PERCEPCION),1)));
        sn7.setMods(List.of(new Modificador(TipoModificador.CIRCUNSTANCIA, "Iniciativa", +2)));
        subidas.add(sn7);

        SubidaNivel sn8= new SubidaNivel(8,cl);
        sn8.setCantidadDotesH(1);
        sn8.setCantidadDotesC(1);
        subidas.add(sn8);
        
        SubidaNivel sn9 = new SubidaNivel(9,cl);
        sn9.setCantidadDotesR(1);
        sn9.setCantidadDotesG(1);
        sn9.setOtros(List.of("Dote de Clase que puedes cambiar en los preparativos diarios. Ademas Si consigues éxito en una tirada de Salvación de Fortaleza, en su lugar obtienes un Éxito Crítico."));
        sn9.setCantidadDotesC(1);
        sn9.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.FORTALEZA),1)));
        subidas.add(sn9);
        
        SubidaNivel sn10= new SubidaNivel(10,cl);
        sn10.setCantidadDotesH(1);
        sn10.setCantidadDotesC(1);
        sn10.setCantidadStats(4);
        subidas.add(sn10);

        SubidaNivel sn11= new SubidaNivel(11,cl);
        sn11.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMADURALIGERA, TipoCompetenciaCombate.ARMADURAPESADA,TipoCompetenciaCombate.ARMADURAMEDIA,
            TipoCompetenciaCombate.SINARMADURA, TipoCompetenciaCombate.CLASE),1)));
        sn11.setOtros(List.of("Obtienes los efectos de especialización de Armadura Media y Pesada."));
        sn11.setCantidadDotesG(1);
        subidas.add(sn11);

        SubidaNivel sn12= new SubidaNivel(12,cl);
        sn12.setCantidadDotesH(1);
        sn12.setCantidadDotesC(1);
        subidas.add(sn12);

        SubidaNivel sn13= new SubidaNivel(13,cl);
        sn13.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMASAVANZADAS),1), 
            new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMASSIMPLES, TipoCompetenciaCombate.SINARMAS,
                TipoCompetenciaCombate.ARMASMARCIALES),1)));
        sn13.setCantidadComp(1); //SUBIDA A LEGENDARIO EN 1 TIPO DE ARMA
        sn13.setCantidadDotesR(1);
        sn13.setCantidadDotesG(1);
        subidas.add(sn13);
        
        SubidaNivel sn14= new SubidaNivel(14,cl);
        sn14.setCantidadDotesH(1);
        sn14.setCantidadDotesC(1);
        subidas.add(sn14);
        
        SubidaNivel sn15= new SubidaNivel(15,cl);
        sn15.setOtros(List.of("+4 al daño con armas. +6 si maestro, +8 si legendario. Además, Si consigues éxito en una tirada de Salvación de Reflejos, en su lugar obtienes un Éxito Crítico. Tambien obtienes una segunda dote que puedes preparar durante tus preparativos diarios."));
        sn15.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.REFLEJOS), 1)));
        sn15.setCantidadDotesG(1);
        sn15.setCantidadStats(4);
        sn15.setCantidadDotesC(1);
        subidas.add(sn15);

        SubidaNivel sn16= new SubidaNivel(16,cl);
        sn16.setCantidadDotesH(1);
        sn16.setCantidadDotesC(1);
        subidas.add(sn16);

        SubidaNivel sn17= new SubidaNivel(17,cl);
        sn17.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMADURALIGERA,TipoCompetenciaCombate.ARMADURAMEDIA,
            TipoCompetenciaCombate.ARMADURAPESADA, TipoCompetenciaCombate.SINARMADURA),1)));
        sn17.setCantidadDotesR(1);
        sn17.setCantidadDotesG(1);
        subidas.add(sn17);

        SubidaNivel sn18= new SubidaNivel(18,cl);
        sn18.setCantidadDotesH(1);
        sn18.setCantidadDotesC(1);
        subidas.add(sn18);

        SubidaNivel sn19= new SubidaNivel(19,cl);
        sn19.setSubidasComp(List.of(new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMASAVANZADAS, 
                TipoCompetenciaCombate.CLASE),1), 
            new SubidaCompetenciaCombate(List.of(TipoCompetenciaCombate.ARMASSIMPLES,TipoCompetenciaCombate.ARMASMARCIALES,
                TipoCompetenciaCombate.SINARMAS),1)));
        sn19.setCantidadDotesG(1);
        subidas.add(sn19);

        SubidaNivel sn20= new SubidaNivel(20,cl);
        sn20.setCantidadDotesH(1);
        sn20.setCantidadDotesC(1);
        sn20.setCantidadStats(4);
        subidas.add(sn20);

        snr.saveAll(subidas);
    }
}
