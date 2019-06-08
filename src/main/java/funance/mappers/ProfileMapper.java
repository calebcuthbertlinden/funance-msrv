package funance.mappers;

import funance.data.Budget;
import funance.data.FinancialProfile;
import funance.data.Gameboard;
import org.springframework.stereotype.Component;
import za.co.discovery.portal.model.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class ProfileMapper {

    public static BudgetResponse mapBudgetResponse(List<Budget> budgetList, FinancialProfile profile) {

        List<CategoryList> list = new ArrayList();

        CategoryList debitOrder = new CategoryList();
        debitOrder.setCategory(Category.DEBIT_ORDER);
        CategoryList food = new CategoryList();
        food.setCategory(Category.FOOD);
        CategoryList misc = new CategoryList();
        misc.setCategory(Category.MISC);
        CategoryList custom = new CategoryList();
        custom.setCategory(Category.CUSTOM);

        int completeAmount = 0;
        for (Budget budget : budgetList) {
            completeAmount = budget.getState().equals("PAYED") ? completeAmount+1 : completeAmount;
            switch (budget.getCategory()) {
                case "DEBIT_ORDER":
                    debitOrder.addBudgetItem(mapBudgetItem(budget));
                    break;
                case "FOOD":
                    food.addBudgetItem(mapBudgetItem(budget));
                    break;
                case "MISC":
                    misc.addBudgetItem(mapBudgetItem(budget));
                    break;
                case "CUSTOM":
                    custom.addBudgetItem(mapBudgetItem(budget));
                    break;
            }
        }

        list.add(debitOrder);
        list.add(food);
        list.add(misc);
        list.add(custom);

        float incomeLeft = profile.getIncome() - getAmountPayed(list);

        return new BudgetResponse()
                .categories(list)
                .amountComplete(completeAmount)
                .amountTotal(getBudgetAmount(list))
                .daysLeftThisMonth(getDaysRemainingThisMonth())
                .outstandingPaymentAmount(getOutstandingAmount(list))
                .income(new BigDecimal(incomeLeft))
                .progress(80);
    }

    private static BigDecimal getOutstandingAmount(List<CategoryList> budgets) {
        float value = 0;
        for (CategoryList c : budgets) {
            if (c.getBudget() != null) {
                for(BudgetItem budget: c.getBudget()) {
                    value += !budget.getState().toString().equals("PAYED") ?
                            budget.getAmount() : 0;
                }
            }

        }
        return BigDecimal.valueOf(value);
    }

    private static float getAmountPayed(List<CategoryList> budgets) {
        float value = 0;
        for (CategoryList c : budgets) {
            if (c.getBudget() != null) {
                for(BudgetItem budget: c.getBudget()) {
                    value += budget.getState().toString().equals("PAYED") ?
                            budget.getAmount() : 0;
                }
            }

        }
        return value;
    }

    private static String getDaysRemainingThisMonth() {

        int number_Of_DaysInMonth = 31;
        String MonthOfName = "Unknown";

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        int day = localDate.getDayOfMonth();

        switch (month) {
            case 1:
                MonthOfName = "January";
                number_Of_DaysInMonth = 31;
                break;
            case 2:
                MonthOfName = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
                break;
            case 3:
                MonthOfName = "March";
                number_Of_DaysInMonth = 31;
                break;
            case 4:
                MonthOfName = "April";
                number_Of_DaysInMonth = 30;
                break;
            case 5:
                MonthOfName = "May";
                number_Of_DaysInMonth = 31;
                break;
            case 6:
                MonthOfName = "June";
                number_Of_DaysInMonth = 30;
                break;
            case 7:
                MonthOfName = "July";
                number_Of_DaysInMonth = 31;
                break;
            case 8:
                MonthOfName = "August";
                number_Of_DaysInMonth = 31;
                break;
            case 9:
                MonthOfName = "September";
                number_Of_DaysInMonth = 30;
                break;
            case 10:
                MonthOfName = "October";
                number_Of_DaysInMonth = 31;
                break;
            case 11:
                MonthOfName = "November";
                number_Of_DaysInMonth = 30;
                break;
            case 12:
                MonthOfName = "December";
                number_Of_DaysInMonth = 31;
                break;
            default:
                MonthOfName = "unknown";
                number_Of_DaysInMonth = 31;
                break;
        }

        return (number_Of_DaysInMonth - day) + " days left in " + MonthOfName;
    }

    private static int getBudgetAmount(List<CategoryList> budgets) {
        int count = 0;
        for (CategoryList b : budgets) {
            count += b.getBudget() != null ? b.getBudget().size() : 0;
        }
        return count;
    }

    public static BudgetItem mapBudgetItem(Budget item) {
        return new BudgetItem()
                .itemId(item.getId())
                .title(item.getTitle())
                .category(Category.fromValue(item.getCategory()))
                .state(BudgetItem.StateEnum.fromValue(item.getState()))
                .onceoff(item.getOnceoff())
                .amount(item.getAmount())
                .description(item.getDescription())
                .date(item.getDate());
    }

    public static BudgetSummary mapBudgetSummary() {
        return new BudgetSummary();
    }

    public static FinanceSummary mapFinanceSummary() {
        return new FinanceSummary();
    }

    public static GameboardSummary mapGameboardSummary() {
        return new GameboardSummary();
    }

    public static GameboardResponse mapGameboard(Gameboard gameboard) {
        return new GameboardResponse()
                .coin(gameboard.getCoins());
    }

    public static long getRandomIntegerBetweenRange(){
        long range = 1234567L;
        Random r = new Random();
        return (long)(r.nextDouble() * range);
    }
}
