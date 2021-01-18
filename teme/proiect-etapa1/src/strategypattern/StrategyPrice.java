package strategypattern;

import transformdata.CalcDistributor;
import transformdata.CalcProducer;

import java.util.ArrayList;

public class StrategyPrice implements Strategy {
    @Override
    public final void chooseStrategy(ArrayList<CalcProducer> list, CalcDistributor distr) {
        int neededEnergy = distr.getEnergyNeededKW();
        double sum = 0;

        for (CalcProducer cp : list) {
            if (neededEnergy > 0) {
                if (cp.getClients().size() < cp.getMaxDistributors()) {
                    distr.getActualProd().add(cp);
                    cp.getClients().add(distr);
                    cp.getClientsId().add(distr.getId());
                    neededEnergy -= cp.getEnergyPerDistributor();
                    sum += cp.getEnergyPerDistributor() * cp.getPriceKW();
                }
            } else {
                break;
            }
        }

        distr.setInitialProductionCost((int) Math.round(Math.floor(sum / 10)));
    }
}
