package br.com.treebu.util;


import br.com.treebu.intelligence.DefinirGeneroFiccao;
import br.com.treebu.model.Recomendacao;
import org.easyrules.api.RulesEngine;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;


/**
 *
 * @author aluno
 */
public class AvaliaRecomendacoes {
    public static void main(String[] args) {
        
        System.out.println("************Inicio da Avaliação*******************");
        
        DefinirGeneroFiccao definirFiccao = new DefinirGeneroFiccao();

        
        
        Recomendacao recomendacao = new Recomendacao(true, true, true);
        
        definirFiccao.setRecomendacao(recomendacao);
        
       RulesEngine mi = aNewRulesEngine().withSilentMode(true).build();
        
       mi.registerRule(definirFiccao);
       mi.fireRules();
        
        System.out.println("****************Fim da Avaliaçao******************");
    }
}
