package com.piratasmall.oakberry.sistema.temperatura.service;

import com.piratasmall.oakberry.sistema.datas.Datas;
import com.piratasmall.oakberry.sistema.temperatura.model.ControleDeTemperatura;
import com.piratasmall.oakberry.sistema.temperatura.model.ManhaOuTarde;
import com.piratasmall.oakberry.sistema.temperatura.model.Temperaturas;
import com.piratasmall.oakberry.sistema.temperatura.repository.ControleDeTemperaturaRepository;
import com.piratasmall.oakberry.sistema.temperatura.repository.TemperaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ControleDeTemperaturaService {

    private final TemperaturaRepository temperaturasRepository;
    private final ControleDeTemperaturaRepository controlerepository;
    private final Datas datas;

    //mostrar contorle de temperatura do dia
    public ControleDeTemperatura mostrarListaDeTemperaturas(){
        Optional<ControleDeTemperatura> controleDeHoje = controlerepository.findByData(datas.hoje());

        if (controleDeHoje.isPresent()){
            return controleDeHoje.get();
        }else {
            ControleDeTemperatura controleDeTemperatura = new ControleDeTemperatura();
            Temperaturas temperaturaManha = new Temperaturas();
            temperaturaManha.setGeladeira(0.0);
            temperaturaManha.setFreezerUm(0.0);
            temperaturaManha.setFreezerDois(0.0);
            temperaturaManha.setManhaOuTarde(ManhaOuTarde.MANHA);
            temperaturaManha.setControle(controleDeTemperatura);

            Temperaturas temperaturaTarde = new Temperaturas();
            temperaturaTarde.setGeladeira(0.0);
            temperaturaTarde.setFreezerUm(0.0);
            temperaturaTarde.setFreezerDois(0.0);
            temperaturaTarde.setManhaOuTarde(ManhaOuTarde.TARDE);
            temperaturaTarde.setControle(controleDeTemperatura);

            controleDeTemperatura.getTemperaturas().add(temperaturaTarde);
            controleDeTemperatura.getTemperaturas().add(temperaturaManha);
            controlerepository.save(controleDeTemperatura);

            return controleDeTemperatura;
        }
    }

    public ControleDeTemperatura atualizarTemperaturaGeladeira(Double valor){
        return atualizarTemperatura(valor,Temperaturas::setGeladeira);
    }


    public ControleDeTemperatura atualizarTemperaturaFreezerUm(Double valor){
        return atualizarTemperatura(valor,Temperaturas::setFreezerUm);
    }

    public ControleDeTemperatura atualizarTemperaturaFreezerDois(Double valor){
        return atualizarTemperatura(valor, Temperaturas::setFreezerDois);
    }

    public ControleDeTemperatura buscarControleDeTemperatura(LocalDate data){
        return controlerepository.findByData(data).orElse(null);
    }

    private ControleDeTemperatura atualizarTemperatura(
            Double valor,
            BiConsumer<Temperaturas, Double> setter){

        ControleDeTemperatura controle = controlerepository.findByData(datas.hoje()).orElseThrow();

        ManhaOuTarde periodo = estaTarde()
                ? ManhaOuTarde.TARDE
                : ManhaOuTarde.MANHA;

        Temperaturas t = controle.getTemperaturas().stream()
                .filter(temp -> temp.getManhaOuTarde() == periodo)
                .findFirst()
                .orElseThrow();

        setter.accept(t,valor);

        temperaturasRepository.save(t);

        return controle;
    }

    private boolean estaTarde(){
        LocalTime fimDaManha = LocalTime.of(12,29);
        if (LocalTime.now().isAfter(fimDaManha)){
            return true;
        }else {
            return false;
        }
    }

}
