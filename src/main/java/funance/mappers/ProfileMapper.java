package funance.mappers;

import funance.data.Budget;
import org.springframework.stereotype.Component;
import za.co.discovery.portal.model.BudgetItem;
import za.co.discovery.portal.model.BudgetResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProfileMapper {

    public static BudgetResponse mapBudgetResponse(List<Budget> budget) {
        return new BudgetResponse()
                .budget(mapBudget(budget))
                .progress(80);
    }

    private static List<BudgetItem> mapBudget(List<Budget> budget) {
        List<BudgetItem> budgetList = new ArrayList<>();
        for (Budget budgetItem : budget) {
            budgetList.add(mapBudgetItem(budgetItem));
        }
        return budgetList;
    }

    public static BudgetItem mapBudgetItem(Budget item) {
        return new BudgetItem()
                .title(item.getTitle())
                .category(BudgetItem.CategoryEnum.fromValue(item.getCategory()))
                .state(BudgetItem.StateEnum.fromValue(item.getState()))
                .onceoff(item.getOnceoff())
                .amount(item.getAmount())
                .date(item.getDate());
    }

    public static long getRandomIntegerBetweenRange(){
        long range = 1234567L;
        Random r = new Random();
        return (long)(r.nextDouble() * range);
    }
}
