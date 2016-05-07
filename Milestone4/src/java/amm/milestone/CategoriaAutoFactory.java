/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone;

import java.util.ArrayList;

/**
 *
 * @author Nando
 */
public class CategoriaAutoFactory {
    private static CategoriaAutoFactory caf;
    static ArrayList<CategoriaAuto> listaCategoriaAuto = null;
    
    public static CategoriaAutoFactory getInstance() {
        if (caf == null)
            caf = new CategoriaAutoFactory();
        return caf;
    }
    private CategoriaAutoFactory() {
        listaCategoriaAuto = new ArrayList<>();
        
        listaCategoriaAuto.add(new CategoriaAuto(1,"Citycar","Un tempo una specialità del tutto italiana e una tipologia di vettura prevalentemente diffusa in Italia, le superutilitarie iniziano a diffondersi globalmente verso gli anni ottanta e novanta fino a essere presenti in quasi tutto il mondo e nei listini di quasi tutte le maggiori case automobilistiche. La vettura racchiude concetti strettamente legati alle esigenze delle città, ovvero ridotte dimensioni e praticità, nonché grande manovrabilità. In Europa le vetture di questo tipo vengono spesso classificate come appartenenti al segmento A, mentre nel mercato nord americano sono quasi del tutto assenti, anche nelle grandi città, salvo esperimenti recenti come la FIAT 500, Smart Fortwo e Mini."));
        listaCategoriaAuto.add(new CategoriaAuto(2,"Berlina","Per berlina si intende la carrozzeria d'autovettura con tetto fisso, generalmente dotata di 4 o 5 porte e principalmente realizzata nelle configurazioni a due, tre o due volumi e mezzo. Il termine berlina indicava, in origine, un particolare tipo di carrozza."));
        listaCategoriaAuto.add(new CategoriaAuto(3,"Coupé","Viene definita coupé la tipologia di auto con carrozzeria chiusa a 2 porte e tetto non rimovibile."));
    }
    public ArrayList<CategoriaAuto> getCategoriaAutoList() {
        return listaCategoriaAuto;
    }
    public String getCategoriaAutoById(Integer id) {
        if (listaCategoriaAuto != null && id != null) {
            for (CategoriaAuto ca : listaCategoriaAuto) {
                if (ca.getId().equals(id))
                    return ca.getCategoria();
            }
        }
        return null;
    }
}
