import java.io.*;
import java.util.*;

public class CompanyProgram
{
   public static void main(String[] args) throws Exception
   {
      Scanner sc = new Scanner(System.in);
      char option = ' ';
      String filename = "LinesNumber.txt";
      int objectNumber = 0;
      
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
      objectNumber = inputFile.nextInt();
      inputFile.close();
      
          
      Company[] CompanyList = createCompanyList(objectNumber);
   
      do {
         System.out.println("\nWelcome!\nOptions:");
         System.out.println("Note that Yearly Revenue is set to 0 initially, use Yearly Revenue in Calculate to calculate it!");
         System.out.println("a. Display Table\nb. Search\nc. Calculate\nd. Sort\ne. Edit/Add Companies\nf. Stop");
         System.out.print("Input here: ");
         option = sc.nextLine().toLowerCase().charAt(0);
      
         while (option != 'A' && option != 'a' && option != 'B' && option != 'b' && option != 'C' && option != 'c' && option != 'D' && option != 'd' && option != 'E' && option != 'e' && option != 'f') {
            System.out.println("\nOption Invalid.");
            System.out.print("\nInput Here:");
            System.out.println("a. Display Table\nb. Search\nc. Calculate\nd. Sort\ne. Edit/Add Companies\nf. Stop");
            System.out.print("Input Option: ");
            option = sc.nextLine().charAt(0);
         }
      
         mainMenu(option, CompanyList);
      }
      while (option != 'F' && option != 'f');
   }
   


   private static Company[] createCompanyList(int x) throws Exception
   {
      Scanner sc = new Scanner(System.in);
      Company[] CompanyList = new Company[x];
      String filename;
    
   
      System.out.print("Input file name to read from: ");
      filename = sc.nextLine();
    
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
    
    
      while (inputFile.hasNext()) {
         for (int i = 0; i < x; i++) {
            String companyName = inputFile.nextLine();
            String companySymbol = inputFile.nextLine();
            int year = Integer.parseInt(inputFile.nextLine());
            int firstQuarterRevenue = Integer.parseInt(inputFile.nextLine());
            int secondQuarterRevenue = Integer.parseInt(inputFile.nextLine());
            int thirdQuarterRevenue = Integer.parseInt(inputFile.nextLine());
            int fourthQuarterRevenue = Integer.parseInt(inputFile.nextLine());
            int grossProfit = Integer.parseInt(inputFile.nextLine());
            int netIncome = Integer.parseInt(inputFile.nextLine());
            String date = inputFile.nextLine();
            int averageVolume = Integer.parseInt(inputFile.nextLine());
            double stockPrice = Double.parseDouble(inputFile.nextLine());
         
            CompanyList[i] = new Company(companyName, companySymbol, year, firstQuarterRevenue, secondQuarterRevenue, thirdQuarterRevenue, fourthQuarterRevenue, grossProfit, netIncome, date, averageVolume, stockPrice);
         }
      }
      inputFile.close();
   
      return CompanyList;
   }


   private static void mainMenu(char x, Company[] CompanyList) throws Exception
   {
      Scanner sc = new Scanner(System.in);
      char option1 = ' ', option2 = ' ', option3 = ' ', option4 = ' ';
   
      if (x == 'A' || x == 'a') {
         printCompanyList(CompanyList);
      }
      
      else if (x == 'B' || x == 'b') {
         System.out.println("\nOptions: ");
         System.out.println("a. Company Name Search\nb. Company Symbol Search\nc. Below, Between, or Above Search\nd. Month Search\ne. Year Search\nf. Stop");
         System.out.print("Input option: ");
         option1 = sc.nextLine().toLowerCase().charAt(0);
         
         searchMenu(option1, CompanyList);
      }
      
      else if (x == 'C' || x == 'c') {
         System.out.println("\nOptions: ");
         System.out.println("a. Percent Change (Stock Price)\nb. Revenue Difference (Two companies, between two quarters or two years, in percentage)\nc. Recalculate Average Volume\nd. Calculate Yearly Revenue");
         System.out.print("Input Option: ");
         option2 = sc.nextLine().toLowerCase().charAt(0);
         
         calculateMenu(option2, CompanyList);
      }
      
      else if (x == 'D' || x == 'd') {
         System.out.println("\nOptions: ");
         System.out.println("a. Sort by Symbol/Company Name\nb. Sort by Yearly Revenue\nc. Sort by Stock Price\nd. Sort by Quarter Revenue\ne. Sort by Average Volume");
         System.out.print("Input Option: ");
         option3 = sc.nextLine().toLowerCase().charAt(0);
      
         sortMenu(option3, CompanyList);
      }
      
      else if (x == 'e') {
         System.out.println("\nOptions:");
         System.out.println("a. Edit Companies\nb. Add Companies (Program must be re-run to show changes!)");
         System.out.print("Choose One: ");
         option4 = sc.nextLine().toLowerCase().charAt(0);
      
         while (option4 != 'a' && option4 != 'b') {
            System.out.println("\nInput Invalid.");
            System.out.println("\nOptions:");
            System.out.println("a. Edit Companies\nb. Add Companies (Program must be re-run to show changes!)");
            System.out.print("Choose One: ");
            option4 = sc.nextLine().toLowerCase().charAt(0);
         }
      
         editAddMenu(option4, CompanyList);
      }
   }


   private static void searchMenu(char x, Company[] CompanyList) {
      if (x == 'a') {
         companyNameSearch(CompanyList);
      }
      
      else if (x == 'b') {
         companySymbolSearch(CompanyList);
      }
      
      else if (x == 'c') {
         belowBetweenAboveSearch(CompanyList);
      }
      
      else if (x == 'd') {
         monthSearch(CompanyList);
      }
      
      else if (x == 'e') {
         yearSearch(CompanyList);
      }
   }


   private static void calculateMenu(char x, Company[] CompanyList)
   {
      if (x == 'a'){
         percentChange(CompanyList);
      }
      
      else if (x == 'b') {
         RevenueDifference(CompanyList);
      }
      
      else if (x == 'c') {
         RecalculateAverageVolume(CompanyList);
      }
      
      else if (x == 'd') {
         yearlyRevenue(CompanyList);
      }
   }


   private static void sortMenu(char option, Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char optionStringSort = ' ';
   
      if (option == 'a') {
         System.out.println("\nOptions: ");
         System.out.println("a. Company Symbol Sort\nb. Company Name Sort");
         System.out.print("Choose One: ");
         optionStringSort = sc.nextLine().toLowerCase().charAt(0);
      
         while (optionStringSort != 'a' && optionStringSort != 'b') {
            System.out.println("\nInput Invalid.");
            System.out.println("\nOptions: ");
            System.out.println("a. Company Symbol Sort\nb. Company Name Sort");
            System.out.print("Choose One: ");
            optionStringSort = sc.nextLine().toLowerCase().charAt(0);
         }
      
         companyStringSort(optionStringSort, x);
      }
      
      else if (option == 'b') {
         sortYearlyRevenue(x);
      }
      
      else if (option == 'c') {
         sortStockPrice(x);
      }
      
      else if (option == 'd') {
         sortQuarterlyRevenue(x);
      }
      
      else if (option == 'e') {
         sortAverageVolume(x);
      }
   }


   private static void editAddMenu(char option, Company[] x) throws Exception
   {   
      if (option == 'a') {
         editData(x);
      }
      
      else if (option == 'b') {
         addData(x);
      }
   }


   private static void printCompanyList(Company[] x)
   {
      String companyNameString = "Company Name", companySymbolString = "Company Symbol", yearString = "Year", firstQuarterRevenueString = "First Quarter Revenue (in thousands)", secondQuarterRevenueString = "Second Quarter Revenue (in thousands)", thirdQuarterRevenueString = "Third Quarter Revenue (in thousands)", fourthQuarterRevenueString = "Fourth Quarter Revenue (in thousands)", yearlyRevenueString = "Yearly Revenue (in thousands)", grossProfitString = "Gross Profit (in thousands)", netIncomeString = "Net Income (in thousands)", dateString = "Date", averageVolumeString = "Average Volume", stockPriceString = "Stock Price (in US dollars)";
   
      System.out.printf("\n%-50s%-20s%-10s%-42s%-42s%-42s%-42s%-40s%-37s%-30s%-25s%-20s%-20s\n", companyNameString, companySymbolString, yearString, firstQuarterRevenueString, secondQuarterRevenueString, thirdQuarterRevenueString, fourthQuarterRevenueString, yearlyRevenueString, grossProfitString, netIncomeString, dateString, averageVolumeString, stockPriceString);
      System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    
      for (int i = 0; i < x.length; i++) {
         System.out.printf("%-50s%-20s%-10d%-42d%-42d%-42d%-42d%-40d%-37d%-30d%-25s%-20d%-20.2f\n", x[i].getCompanyName(), x[i].getCompanySymbol(), x[i].getYear(), x[i].getFirstQuarterRevenue(), x[i].getSecondQuarterRevenue(), x[i].getThirdQuarterRevenue(), x[i].getFourthQuarterRevenue(), x[i].getYearlyRevenue(), x[i].getGrossProfit(), x[i].getNetIncome(), x[i].getDate(), x[i].getAverageVolume(), x[i].getStockPrice());
      }
      System.out.println("\n");
   }


   private static void companyNameSearch(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      String company = "", companyNameString = "Company Name", companySymbolString = "Company Symbol", yearString = "Year", firstQuarterRevenueString = "First Quarter Revenue (in thousands)", secondQuarterRevenueString = "Second Quarter Revenue (in thousands)", thirdQuarterRevenueString = "Third Quarter Revenue (in thousands)", fourthQuarterRevenueString = "Fourth Quarter Revenue (in thousands)", yearlyRevenueString = "Yearly Revenue (in thousands)", grossProfitString = "Gross Profit (in thousands)", netIncomeString = "Net Income (in thousands)", dateString = "Date", averageVolumeString = "Average Volume", stockPriceString = "Stock Price (in US dollars)";
      Boolean checker = false, printerChecker = false;
   
      do {
         System.out.print("\n\nInput Company Name to Search or \"stop\" to return: ");
         company = sc.nextLine().toLowerCase();
         company = company.replaceAll("[^a-zA-Z]", "");
         
         for (int i = 0; i < x.length; i++) {
            if (x[i].getCompanyName().toLowerCase().replaceAll("[^a-zA-Z]", "").contains(company) == true) {
               printerChecker = true;
            }
         }
         
         if (printerChecker == true) {
            System.out.printf("\n%-50s%-20s%-10s%-42s%-42s%-42s%-42s%-40s%-37s%-30s%-25s%-20s%-20s\n", companyNameString, companySymbolString, yearString, firstQuarterRevenueString, secondQuarterRevenueString, thirdQuarterRevenueString, fourthQuarterRevenueString, yearlyRevenueString, grossProfitString, netIncomeString, dateString, averageVolumeString, stockPriceString);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            printerChecker = false;
         }
      
         for (int i = 0; i < x.length; i++) {
            if (x[i].getCompanyName().toLowerCase().replaceAll("[^a-zA-Z]", "").contains(company) == true) {
               System.out.printf("%-50s%-20s%-10d%-42d%-42d%-42d%-42d%-40d%-37d%-30d%-25s%-20d%-20.2f\n", x[i].getCompanyName(), x[i].getCompanySymbol(), x[i].getYear(), x[i].getFirstQuarterRevenue(), x[i].getSecondQuarterRevenue(), x[i].getThirdQuarterRevenue(), x[i].getFourthQuarterRevenue(), x[i].getYearlyRevenue(), x[i].getGrossProfit(), x[i].getNetIncome(), x[i].getDate(), x[i].getAverageVolume(), x[i].getStockPrice());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nCompany Not Found");
         }
         checker = false;
      }
      
      while (company.equals("stop") == false);
   }


   private static void companySymbolSearch(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      String symbol = "", companyNameString = "Company Name", companySymbolString = "Company Symbol", yearString = "Year", firstQuarterRevenueString = "First Quarter Revenue (in thousands)", secondQuarterRevenueString = "Second Quarter Revenue (in thousands)", thirdQuarterRevenueString = "Third Quarter Revenue (in thousands)", fourthQuarterRevenueString = "Fourth Quarter Revenue (in thousands)", yearlyRevenueString = "Yearly Revenue (in thousands)", grossProfitString = "Gross Profit (in thousands)", netIncomeString = "Net Income (in thousands)", dateString = "Date", averageVolumeString = "Average Volume", stockPriceString = "Stock Price (in US dollars)";;
      Boolean checker = false, printerChecker = false;
   
      do {
         System.out.print("\nInput Company Symbol to Search or \"stop\" to return: ");
         symbol = sc.nextLine().toLowerCase();
         
         for (int i = 0; i < x.length; i++) {
            if (x[i].getCompanySymbol().toLowerCase().contains(symbol) == true) {
               printerChecker = true;
            }
         }
         
         if (printerChecker == true) {
            System.out.printf("\n%-50s%-20s%-10s%-42s%-42s%-42s%-42s%-40s%-37s%-30s%-25s%-20s%-20s\n", companyNameString, companySymbolString, yearString, firstQuarterRevenueString, secondQuarterRevenueString, thirdQuarterRevenueString, fourthQuarterRevenueString, yearlyRevenueString, grossProfitString, netIncomeString, dateString, averageVolumeString, stockPriceString);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            printerChecker = false;
         }
      
         for (int i = 0; i < x.length; i++) {
            if (x[i].getCompanySymbol().toLowerCase().contains(symbol) == true) {
               System.out.printf("%-50s%-20s%-10d%-42d%-42d%-42d%-42d%-40d%-37d%-30d%-25s%-20d%-20.2f\n", x[i].getCompanyName(), x[i].getCompanySymbol(), x[i].getYear(), x[i].getFirstQuarterRevenue(), x[i].getSecondQuarterRevenue(), x[i].getThirdQuarterRevenue(), x[i].getFourthQuarterRevenue(), x[i].getYearlyRevenue(), x[i].getGrossProfit(), x[i].getNetIncome(), x[i].getDate(), x[i].getAverageVolume(), x[i].getStockPrice());
               checker = true;
            }
         
         }
         if (checker == false) {
            System.out.println("\nCompany Not Found");
         }
      
      }
      
      while (symbol.equals("stop") == false);
   }

   
   private static void belowBetweenAboveSearch(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char option = ' ', optionSearch = ' ';
   
      do {
         System.out.println("\nSelect one option to search on:");
         System.out.println("\na. First Quarter Revenue\nb. Second Quarter Revenue\nc. Third Quarter Revenue\nd. Fourth Quarter Revenue\ne. Yearly Revenue\nf. Gross Profit\ng. Net Income\nh. Average Volume\ni. Stock Price\nj. Stop");
         System.out.print("Input Option: ");
         optionSearch = sc.nextLine().toLowerCase().charAt(0);
      
         while (optionSearch != 'a' && optionSearch != 'b' && optionSearch != 'c' && optionSearch != 'd' && optionSearch != 'e' && optionSearch != 'f' && optionSearch != 'g' && optionSearch != 'h' && optionSearch != 'i' && optionSearch != 'j') {
            System.out.println("\nInput Invalid.");
            System.out.println("\nSelect one option to search on:");
            System.out.println("a. First Quarter Revenue\nb. Second Quarter Revenue\nc. Third Quarter Revenue\nd. Fourth Quarter Revenue\ne. Yearly Revenue\nf. Gross Profit\ng. Net Income\nh. Average Volume\ni. Stock Price\nj. Stop");
            System.out.print("Input Option: ");
            optionSearch = sc.nextLine().toLowerCase().charAt(0);
         }
         
         if (optionSearch == 'j') {
            break;
         }
      
         System.out.println("\nSelect one search option: ");
         System.out.println("a. Below Search\nb. Between Search\nc. Above Search\nd. Stop");
         System.out.print("Input Option: ");
         option = sc.nextLine().charAt(0);
      
         while (option != 'A' && option != 'a' && option != 'B' && option != 'b' && option != 'C' && option != 'c' && option != 'D' && option != 'd') {
            System.out.println("\nInput Invalid.");
            System.out.println("\nSelect one option: ");
            System.out.println("a. Below Search\nb. Between Search\nc. Above Search\nd. Stop");
            
            System.out.print("Input Option: ");
            option = sc.nextLine().toLowerCase().charAt(0);
         }
      
         if (option == 'a') {
            BelowSearch(optionSearch, x);
         }
         
         else if (option == 'b') {
            BetweenSearch(optionSearch, x);
         }
         
         else if (option == 'c') {
            AboveSearch(optionSearch, x);
         }
      }
      
      while (option != 'd');
      
   }


   private static void BelowSearch(char optionSearch, Company[] x) {
      Scanner sc = new Scanner(System.in);
      double value, sub = 0;
      Boolean checker = false;
   
      System.out.print("\nInput value for Below Search (in thousands of dollars for Revenues, Gross Profit, \nand Net Income; actual amount for average volume; dollars for stock price): ");
      value = sc.nextInt();
   
      if (optionSearch == 'a') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getFirstQuarterRevenue();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("First Quarter Revenue: " + x[i].getFirstQuarterRevenue());
               checker = true;
            }
         }
      
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'b') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getSecondQuarterRevenue();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Second Quarter Revenue: " + x[i].getSecondQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'c') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getThirdQuarterRevenue();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Third Quarter Revenue: " + x[i].getThirdQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'd') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getFourthQuarterRevenue();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Second Quarter Revenue: " + x[i].getFourthQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'e') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getYearlyRevenue();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Yearly Revenue: " + x[i].getYearlyRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'f') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getGrossProfit();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Gross Profit: " + x[i].getGrossProfit());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'g') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getNetIncome();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Net Income: " + x[i].getNetIncome());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'h') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getAverageVolume();
            if (sub < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Date: " + x[i].getDate());
               System.out.println("Average Volume: " + x[i].getAverageVolume());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'i') {
         for (int i = 0; i < x.length; i++) {
            if (x[i].getStockPrice() < value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Date: " + x[i].getDate());
               System.out.println("Stock Price: " + x[i].getStockPrice());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
   }


   private static void AboveSearch(char optionSearch, Company[] x) {
      Scanner sc = new Scanner(System.in);
      double value, sub = 0;
      Boolean checker = false;
   
      System.out.print("\nInput value for Above Search (in thousands of dollars for Revenues, Gross Profit, \nand Net Income; actual amount for average volume; dollars for stock price): ");
      value = sc.nextDouble();
   
      if (optionSearch == 'a') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getFirstQuarterRevenue();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("First Quarter Revenue: " + x[i].getFirstQuarterRevenue());
               checker = true;
            }
         }
      
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'b') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getSecondQuarterRevenue();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Second Quarter Revenue: " + x[i].getSecondQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'c') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getThirdQuarterRevenue();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Third Quarter Revenue: " + x[i].getThirdQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'd') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getFourthQuarterRevenue();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Second Quarter Revenue: " + x[i].getFourthQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'e') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getYearlyRevenue();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Yearly Revenue: " + x[i].getYearlyRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'f') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getGrossProfit();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Gross Profit: " + x[i].getGrossProfit());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'g') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getNetIncome();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Net Income: " + x[i].getNetIncome());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'h') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getAverageVolume();
            if (sub > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Date: " + x[i].getDate());
               System.out.println("Average Volume: " + x[i].getAverageVolume());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'i') {
         for (int i = 0; i < x.length; i++) {
            if (x[i].getStockPrice() > value) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Date: " + x[i].getDate());
               System.out.println("Stock Price: " + x[i].getStockPrice());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
   }


   private static void BetweenSearch(char optionSearch, Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      double lower, higher, sub = 0;
      Boolean checker = false;
   
      System.out.print("\nInput lower boundary for Above Search (in thousands of dollars for Revenues, Gross Profit, \nand Net Income; actual amount for average volume; dollars for stock price): ");
      lower = sc.nextInt();
   
      System.out.print("\nInput higher boundary for Above Search (in thousands of dollars for Revenues, Gross Profit, \nand Net Income; actual amount for average volume; dollars for stock price): ");
      higher = sc.nextInt();
   
      while (lower >= higher) {
         System.out.println("\nInput invalid.");
         System.out.println("Input lower boundary for Above Search (in thousands of dollars for Revenues, Gross Profit, and Net Income; actual amount for average volume; dollars for stock price): ");
         lower = sc.nextInt();
      
         System.out.println("Input higher boundary for Above Search (in thousands of dollars for Revenues, Gross Profit, and Net Income; actual amount for average volume; dollars for stock price): ");
         higher = sc.nextInt();
      }
   
      if (optionSearch == 'a') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getFirstQuarterRevenue();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("First Quarter Revenue: " + x[i].getFirstQuarterRevenue());
               checker = true;
            }
         }
      
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'b') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getSecondQuarterRevenue();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Second Quarter Revenue: " + x[i].getSecondQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'c') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getThirdQuarterRevenue();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Third Quarter Revenue: " + x[i].getThirdQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'd') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getFourthQuarterRevenue();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Fourth Quarter Revenue: " + x[i].getFourthQuarterRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'e') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getYearlyRevenue();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Yearly Revenue: " + x[i].getYearlyRevenue());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'f') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getGrossProfit();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Gross Profit: " + x[i].getGrossProfit());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'g') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getNetIncome();
            if (sub > lower && sub < higher){
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Year: " + x[i].getYear());
               System.out.println("*Data is in thousands of dollars*");
               System.out.println("Net Income: " + x[i].getNetIncome());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'h') {
         for (int i = 0; i < x.length; i++) {
            sub = x[i].getAverageVolume();
            if (sub > lower && sub < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Date: " + x[i].getDate());
               System.out.println("Average Volume: " + x[i].getAverageVolume());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
      
      else if (optionSearch == 'i') {
         for (int i = 0; i < x.length; i++) {
            if (x[i].getStockPrice() > lower && x[i].getStockPrice() < higher) {
               System.out.println("\nCompany Name: " + x[i].getCompanyName());
               System.out.println("Company Symbol: " + x[i].getCompanySymbol());
               System.out.println("Date: " + x[i].getDate());
               System.out.println("Stock Price: " + x[i].getStockPrice());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("\nNot Found");
         }
      }
   }


   private static void monthSearch(Company[] x) 
   {
      Scanner sc = new Scanner(System.in);
      String month, companyNameString = "Company Name", companySymbolString = "Company Symbol", yearString = "Year", firstQuarterRevenueString = "First Quarter Revenue (in thousands)", secondQuarterRevenueString = "Second Quarter Revenue (in thousands)", thirdQuarterRevenueString = "Third Quarter Revenue (in thousands)", fourthQuarterRevenueString = "Fourth Quarter Revenue (in thousands)", yearlyRevenueString = "Yearly Revenue (in thousands)", grossProfitString = "Gross Profit (in thousands)", netIncomeString = "Net Income (in thousands)", dateString = "Date", averageVolumeString = "Average Volume", stockPriceString = "Stock Price (in US dollars)";;
      Boolean checker = false, printerChecker = false;
   
      do {
         System.out.print("\nInput Month to Search or \"stop\" to return: ");
         month = sc.nextLine();
         month = month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase();
         
         if (month.toLowerCase().equals("stop") == true) {
            break;
         }
      
         for (int i = 0; i < x.length; i++) {
            if (x[i].getDate().contains(month) == true) {
               printerChecker = true;
            }
         }
            
         if (printerChecker == true) {
            System.out.printf("\n%-50s%-20s%-10s%-42s%-42s%-42s%-42s%-40s%-37s%-30s%-25s%-20s%-20s\n", companyNameString, companySymbolString, yearString, firstQuarterRevenueString, secondQuarterRevenueString, thirdQuarterRevenueString, fourthQuarterRevenueString, yearlyRevenueString, grossProfitString, netIncomeString, dateString, averageVolumeString, stockPriceString);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            printerChecker = false;
         }
         
         for (int i = 0; i < x.length; i++) {
            if (x[i].getDate().contains(month) == true) {
               System.out.printf("%-50s%-20s%-10d%-42d%-42d%-42d%-42d%-40d%-37d%-30d%-25s%-20d%-20.2f\n", x[i].getCompanyName(), x[i].getCompanySymbol(), x[i].getYear(), x[i].getFirstQuarterRevenue(), x[i].getSecondQuarterRevenue(), x[i].getThirdQuarterRevenue(), x[i].getFourthQuarterRevenue(), x[i].getYearlyRevenue(), x[i].getGrossProfit(), x[i].getNetIncome(), x[i].getDate(), x[i].getAverageVolume(), x[i].getStockPrice());
               checker = true;
            }
         }
         if (checker == false) {
            System.out.println("Date Not Found");
         }
      }
      
      while (month.toLowerCase().equals("stop") == false);
   }


   private static void yearSearch(Company[] x) 
   {
      Scanner sc = new Scanner(System.in);
      int year;
      String companyNameString = "Company Name", companySymbolString = "Company Symbol", yearString = "Year", firstQuarterRevenueString = "First Quarter Revenue (in thousands)", secondQuarterRevenueString = "Second Quarter Revenue (in thousands)", thirdQuarterRevenueString = "Third Quarter Revenue (in thousands)", fourthQuarterRevenueString = "Fourth Quarter Revenue (in thousands)", yearlyRevenueString = "Yearly Revenue (in thousands)", grossProfitString = "Gross Profit (in thousands)", netIncomeString = "Net Income (in thousands)", dateString = "Date", averageVolumeString = "Average Volume", stockPriceString = "Stock Price (in US dollars)";
      Boolean checker = false, printerChecker = false;
   
      System.out.print("\nInput Year to Search: ");
      year = sc.nextInt();
      
      for (int i = 0; i < x.length; i++) {
         if (x[i].getYear() == year) {
            printerChecker = true;
         }
      }
      
      if (printerChecker == true) {
         System.out.printf("\n%-50s%-20s%-10s%-42s%-42s%-42s%-42s%-40s%-37s%-30s%-25s%-20s%-20s\n", companyNameString, companySymbolString, yearString, firstQuarterRevenueString, secondQuarterRevenueString, thirdQuarterRevenueString, fourthQuarterRevenueString, yearlyRevenueString, grossProfitString, netIncomeString, dateString, averageVolumeString, stockPriceString);
         System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      }
      
      for (int i = 0; i < x.length; i++) {
         if (x[i].getYear() == year) {
            System.out.printf("%-50s%-20s%-10d%-42d%-42d%-42d%-42d%-40d%-37d%-30d%-25s%-20d%-20.2f\n", x[i].getCompanyName(), x[i].getCompanySymbol(), x[i].getYear(), x[i].getFirstQuarterRevenue(), x[i].getSecondQuarterRevenue(), x[i].getThirdQuarterRevenue(), x[i].getFourthQuarterRevenue(), x[i].getYearlyRevenue(), x[i].getGrossProfit(), x[i].getNetIncome(), x[i].getDate(), x[i].getAverageVolume(), x[i].getStockPrice());
         
            checker = true;
         }
      }
      if (checker == false) {
         System.out.println("Date Not Found");
      }
   }


   private static void percentChange(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      String company;
      int percentChange;
      Boolean checker = false, available1 = false;
      
      System.out.print("\nInput Company Name: ");
      company = sc.nextLine().toLowerCase();
   
      for (int j = 0; j < x.length; j++) {
         if (x[j].getCompanyName().toLowerCase().contains(company) == true) {
            available1 = true;
         }
      }
   
      while (available1 == false) {
         System.out.print("\nCompany Not Found.\n\nInput Company Name: ");
         company = sc.nextLine().toLowerCase();
      
         for (int k = 0; k < x.length; k++) {
            if (x[k].getCompanyName().toLowerCase().contains(company) == true) {
               available1 = true;
            }
         }
      }
   
      System.out.print("\nInput Percent Change (without the \"%\" symbol): ");
      percentChange = sc.nextInt();
   
      while (percentChange < 0 || percentChange > 100) {
         System.out.println("\nInput Invalid.");
         System.out.print("\nInput Percent Change (without the \"%\" symbol): ");
         percentChange = sc.nextInt();
      }
   
   
      for (int i = 0; i < x.length; i++) {
         if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
            x[i].calculateNewStockPrice(percentChange);
            System.out.printf("\n%s%s%s%.2f%s\n", "The new stock price of company ", x[i].getCompanyName(), " is ", x[i].getStockPrice(), " dollars.");
            checker = true;
         }
      }
      if (checker == false) {
         System.out.println("\nNot Found");
      }
   }


   private static void RevenueDifference(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char optionDiff = ' ', option1 = ' ', option2 = ' ';
      Boolean available1 = false, available2 = false;
      String company1 = "", company2 = "", companySub1 = "", companySub2 = "", quarterSub1 = "", quarterSub2 = "";
      int sub1 = 0, sub2 = 0, diff = 0;
      
      do {
         System.out.println("\nOptions:");
         System.out.println("a. Between two yearly revenues of two companies\nb. Between two quarterly revenues");
         System.out.print("Choose One: ");
         optionDiff = sc.nextLine().toLowerCase().charAt(0);
      
         while (optionDiff != 'a' && optionDiff != 'b') {
            System.out.println("\nInput Invalid.");
            System.out.println("\nOptions:");
            System.out.println("a. Between yearly revenues of two companies\nb. Between quartal revenues of one company");
            System.out.print("Choose One: ");
            optionDiff = sc.nextLine().toLowerCase().charAt(0);
         }
      
         
         if (optionDiff == 'a') {
            System.out.print("\nInput First Company Name to calculate yearly revenue difference (be specific) or \"stop\" to end search: ");
            company1 = sc.nextLine().toLowerCase();
         
            if (company1.equals("stop") == true) {
               break;
            }
         
            for (int j = 0; j < x.length; j++) {
               if (x[j].getCompanyName().toLowerCase().contains(company1) == true) {
                  available1 = true;
               }
            }
         
            while (available1 == false) {
               System.out.print("\nCompany Not Found.\n\nInput First Company Name to calculate yearly revenue difference (be specific) or \"stop\" to end search: ");
               company1 = sc.nextLine().toLowerCase();
            
               if (company1.equals("stop") == true) {
                  break;
               }
            
               for (int k = 0; k < x.length; k++) {
                  if (x[k].getCompanyName().toLowerCase().contains(company1) == true) {
                     available1 = true;
                  }
               }
            }
            if (company1.equals("stop") == true) {
               break;
            }
         
         
            System.out.print("\nInput Second Company Name to calculate yearly revenue difference (be specific) or \"stop\" to end search: ");
            company2 = sc.nextLine().toLowerCase();
         
            if (company2.equals("stop") == true) {
               break;
            }
         
            for (int l = 0; l < x.length; l++) {
               if (x[l].getCompanyName().toLowerCase().contains(company2) == true) {
                  available2 = true;
               }
            }
         
            while (available2 == false) {
               System.out.print("\nCompany Not Found.\n\nInput Second Company Name to calculate yearly revenue difference (be specific) or \"stop\" to end search: ");
               company2 = sc.nextLine().toLowerCase();
            
               if (company2.equals("stop") == true) {
                  break;
               }
            
               for (int m = 0; m < x.length; m++) {
                  if (x[m].getCompanyName().toLowerCase().contains(company2) == true) {
                     available2 = true;
                  }
               }
            }
         
            if (company2.equals("stop") == true) {
               break;
            }
         
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company1) == true) {
                  sub1 = x[i].getYearlyRevenue();
                  companySub1 = x[i].getCompanyName();
               }
               else if (x[i].getCompanyName().toLowerCase().contains(company2) == true) {
                  sub2 = x[i].getYearlyRevenue();
                  companySub2 = x[i].getCompanyName();
               }
            }
            diff = sub1 - sub2;
            System.out.printf("\n%s%s%s%s%s%d%s\n", "The yearly revenue difference between the company \"", companySub1, "\" and the company \"", companySub2, "\" is ", diff, " (in thousands).");
         }
         
         else if (optionDiff == 'b') {
            System.out.print("\nInput Company Name to count yearly revenue difference (be specific) or \"stop\" to end search: ");
            company1 = sc.nextLine().toLowerCase();
         
            if (company1.equals("stop") == true) {
               break;
            }
         
            for (int j = 0; j < x.length; j++) {
               if (x[j].getCompanyName().toLowerCase().contains(company1) == true) {
                  available1 = true;
               }
            }
         
            while (available1 == false) {
               System.out.print("\nCompany Not Found.\n\nInput Company Name to count yearly revenue difference (be specific) or \"stop\" to end search: ");
               company1 = sc.nextLine().toLowerCase();
            
               if (company1.equals("stop") == true) {
                  break;
               }
            
               for (int k = 0; k < x.length; k++) {
                  if (x[k].getCompanyName().toLowerCase().contains(company1) == true) {
                     available1 = true;
                  }
               }
            }
         
            if (company1.equals("stop") == true) {
               break;
            }
         
            System.out.println("\nChoose first quarter to find difference: ");
            System.out.println("a. First Quarter\nb. Second Quarter\nc. Third Quarter\nd. Fourth Quarter");
            System.out.print("Input Choice: ");
            option1 = sc.nextLine().toLowerCase().charAt(0);
         
            if (option1 != 'a' && option1 != 'b' && option1 != 'c' && option1 != 'd') {
               System.out.println("\nInput Invalid.");
               System.out.println("\nChoose first quarter to find difference: ");
               System.out.println("a. First Quarter\nb. Second Quarter\nc. Third Quarter\nd. Fourth Quarter");
               System.out.print("Input Choice: ");
               option1 = sc.nextLine().toLowerCase().charAt(0);
            }
         
            System.out.println("\nChoose second quarter to find difference: ");
            System.out.println("a. First Quarter\nb. Second Quarter\nc. Third Quarter\nd. Fourth Quarter");
            System.out.print("Input Choice: ");
            option2 = sc.nextLine().toLowerCase().charAt(0);
         
            if (option2 != 'a' && option2 != 'b' && option2 != 'c' && option2 != 'd') {
               System.out.println("\nInput Invalid.");
               System.out.println("\nChoose first quarter to find difference: ");
               System.out.println("a. First Quarter\nb. Second Quarter\nc. Third Quarter\nd. Fourth Quarter");
               System.out.print("Input Choice: ");
               option2 = sc.nextLine().toLowerCase().charAt(0);
            }
            
            if (option1 == 'a') {
               for (int t = 0; t < x.length; t++) {
                  if (x[t].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[t].getFirstQuarterRevenue();
                     quarterSub1 = "First Quarter";
                     companySub1 = x[t].getCompanyName();
                  }
               }
            }
            
            else if (option1 == 'b') {
               for (int h = 0; h < x.length; h++) {
                  if (x[h].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[h].getSecondQuarterRevenue();
                     quarterSub1 = "Second Quarter";
                     companySub1 = x[h].getCompanyName();
                  }
               }
            }
            
            else if (option1 == 'c') {
               for (int u = 0; u < x.length; u++) {
                  if (x[u].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[u].getThirdQuarterRevenue();
                     quarterSub1 = "Third Quarter";
                     companySub1 = x[u].getCompanyName();
                  }
               }
            }
            
            else if (option1 == 'd') {
               for (int r = 0; r < x.length; r++) {
                  if (x[r].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[r].getFourthQuarterRevenue();
                     quarterSub1 = "Fourth Quarter";
                     companySub1 = x[r].getCompanyName();
                  }
               }
            }
         
            if (option2 == 'a') {
               for (int q = 0; q < x.length; q++) {
                  if (x[q].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[q].getFirstQuarterRevenue();
                     quarterSub2 = "First Quarter";
                     companySub1 = x[q].getCompanyName();
                  }
               }
            }
            
            else if (option2 == 'b') {
               for (int w = 0; w < x.length; w++) {
                  if (x[w].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[w].getSecondQuarterRevenue();
                     quarterSub2 = "Second Quarter";
                     companySub1 = x[w].getCompanyName();
                  }
               }
            }
            
            else if (option2 == 'c') {
               for (int a = 0; a < x.length; a++) {
                  if (x[a].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[a].getThirdQuarterRevenue();
                     quarterSub2 = "Third Quarter";
                     companySub1 = x[a].getCompanyName();
                  }
               }
            }
            
            else if (option2 == 'd') {
               for (int d = 0; d < x.length; d++) {
                  if (x[d].getCompanyName().toLowerCase().contains(company1) == true) {
                     sub1 = x[d].getSecondQuarterRevenue();
                     quarterSub2 = "Fourth Quarter";
                     companySub1 = x[d].getCompanyName();
                  }
               }
            }
            
            diff = sub1 - sub2;
         
            System.out.printf("\n%s%s%s%s%s%s%s%d%s\n", "The difference between the ", quarterSub1, " and the ", quarterSub2, " of the company \"", companySub1, "\" is ", diff, " (in thousands).");
         }
      }
      while (company1.toLowerCase().equals("stop") == true);
   }


   private static void RecalculateAverageVolume(Company[] x) {
      Scanner sc = new Scanner(System.in);
      String company;
      int total = 0, average;
      Boolean checker = false, available1 = false;
      
      System.out.print("\nInput Company Name: ");
      company = sc.nextLine();
   
      for (int j = 0; j < x.length; j++) {
         if (x[j].getCompanyName().toLowerCase().contains(company) == true) {
            available1 = true;
         }
      }
   
      while (available1 == false) {
         System.out.print("\nCompany Not Found.\n\nInput Company Name: ");
         company = sc.nextLine().toLowerCase();
      
         for (int k = 0; k < x.length; k++) {
            if (x[k].getCompanyName().toLowerCase().contains(company) == true) {
               available1 = true;
            }
         }
      }
   
      System.out.println("Input 10 values to recalculate average volume: ");
      for (int i = 0; i < 10; i++) {
         total += sc.nextInt();
      }
      average = total / 10;
   
      for (int a = 0; a < x.length; a++) {
         if (x[a].getCompanyName().toLowerCase().contains(company) == true) {
            x[a].setAverageVolume(average);
            System.out.printf("\n%s%s%s%s%s%d%s\n","The new average volume for the company ", x[a].getCompanyName(), " on the date ", x[a].getDate(), " is ", x[a].getAverageVolume(), ".");
            checker = true;
         }
      }
      if (checker == false) {
         System.out.println("\nNot Found");
      }
   }


   private static Company[] yearlyRevenue(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char ans = ' ';
      
      System.out.print("\nCalculate for Yearly Revenue of All Companies? Y/N: ");
      ans = sc.nextLine().toLowerCase().charAt(0);
   
      if (ans == 'y'){
         for (int i = 0; i < x.length; i++) {
            x[i].calculateYearlyRevenue();
         }
         System.out.println("Calculation Complete.");
      }
      else if (ans == 'n') {
      }
      return x;
   }

   
   private static Company[] companyStringSort(char option, Company[] x) {
      Scanner sc = new Scanner(System.in);
      Company sub;
      char orderInput = ' ';
   
      System.out.println("\nOptions:\na. Ascending\nb. Descending");
      System.out.print("Choose One: ");
      orderInput = sc.nextLine().toLowerCase().charAt(0);
   
      while (orderInput != 'a' && orderInput != 'b') {
         System.out.println("Input Invalid.");
         System.out.println("\nOptions:\na. Ascending\nb. Descending");
         System.out.print("Choose One: ");
         orderInput = sc.nextLine().toLowerCase().charAt(0);
      }
   
      if (option == 'a' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getCompanySymbol().toLowerCase().replaceAll("[^a-zA-Z]", "").compareTo(x[j+1].getCompanySymbol().toLowerCase().replaceAll("[^a-zA-Z]", "")) >= 0) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'a' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getCompanySymbol().toLowerCase().replaceAll("[^a-zA-Z]", "").compareTo(x[j+1].getCompanySymbol().toLowerCase().replaceAll("[^a-zA-Z]", "")) < 0) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'b' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getCompanyName().toLowerCase().compareTo(x[j+1].getCompanyName().toLowerCase()) >= 0) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'b' && orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getCompanyName().toLowerCase().compareTo(x[j+1].getCompanyName().toLowerCase()) < 0) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      System.out.println("Sort Complete.");
      return x;
   }


   private static Company[] sortYearlyRevenue(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char orderInput = ' ';
      Company sub;
   
      System.out.println("\nOptions:\na. Ascending\nb. Descending");
      System.out.print("Choose One: ");
      orderInput = sc.nextLine().toLowerCase().charAt(0);
   
      while (orderInput != 'a' && orderInput != 'b') {
         System.out.println("\nInput Invalid.");
         System.out.println("\nOptions:\na. Ascending\nb. Descending");
         System.out.print("Choose One: ");
         orderInput = sc.nextLine().toLowerCase().charAt(0);
      }
   
      if (orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getYearlyRevenue() > x[j+1].getYearlyRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      
      else if (orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getYearlyRevenue() < x[j+1].getYearlyRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      System.out.println("Sort Complete.");
      return x;
   }


   private static Company[] sortStockPrice(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char orderInput = ' ';
      Company sub;
   
      System.out.println("\nOptions:\na. Ascending\nb. Descending");
      System.out.print("Choose One: ");
      orderInput = sc.nextLine().toLowerCase().charAt(0);
   
      while (orderInput != 'a' && orderInput != 'b') {
         System.out.println("\nInput Invalid.");
         System.out.println("\nOptions:\na. Ascending\nb. Descending");
         System.out.print("Choose One: ");
         orderInput = sc.nextLine().toLowerCase().charAt(0);
      }
   
      if (orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getStockPrice() > x[j+1].getStockPrice()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      
      else if (orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getStockPrice() < x[j+1].getStockPrice()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      System.out.println("Sort Complete.");
      return x;
   }


   private static Company[] sortQuarterlyRevenue(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char option = ' ', orderInput = ' ';
      Company sub;
   
      System.out.println("\nOptions:\na. First Quarter\nb. Second Quarter\nc. Third Quarter\nd. Fourth Quarter");
      System.out.print("Choose One: ");
      option = sc.nextLine().toLowerCase().charAt(0);
   
      while (option!= 'a' && option != 'b' && option != 'c' && option != 'd') {
         System.out.println("\nInput Invalid.");
         System.out.println("\nOptions:\na. First Quarter\nb. Second Quarter\nc. Third Quarter\nd. Fourth Quarter");
         System.out.print("Choose One: ");
         option = sc.nextLine().toLowerCase().charAt(0);
      }
   
      System.out.println("\nOptions:\na. Ascending\nb. Descending");
      System.out.print("Choose One: ");
      orderInput = sc.nextLine().toLowerCase().charAt(0);
   
      while (orderInput != 'a' && orderInput != 'b') {
         System.out.println("Input Invalid.");
         System.out.println("\nOptions:\na. Ascending\nb. Descending");
         System.out.print("Choose One: ");
         orderInput = sc.nextLine().toLowerCase().charAt(0);
      }
   
   
      if (option == 'a' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getFirstQuarterRevenue() > x[j+1].getFirstQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'a' && orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getFirstQuarterRevenue() < x[j+1].getFirstQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'b' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getSecondQuarterRevenue() > x[j+1].getSecondQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'b' && orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getSecondQuarterRevenue() < x[j+1].getSecondQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'c' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getThirdQuarterRevenue() > x[j+1].getThirdQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'c' && orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getThirdQuarterRevenue() < x[j+1].getThirdQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'd' && orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getFourthQuarterRevenue() > x[j+1].getFourthQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (option == 'd' && orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getFourthQuarterRevenue() < x[j+1].getFourthQuarterRevenue()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
   
      System.out.println("Sort Complete.");
      return x;
   }


   private static Company[] sortAverageVolume(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      char orderInput = ' ';
      Company sub;
      
      System.out.println("\nOptions:\na. Ascending\nb. Descending");
      System.out.print("Choose One: ");
      orderInput = sc.nextLine().toLowerCase().charAt(0);
   
      while (orderInput != 'a' && orderInput != 'b') {
         System.out.println("\nInput Invalid.");
         System.out.println("\nOptions:\na. Ascending\nb. Descending");
         System.out.print("Choose One: ");
         orderInput = sc.nextLine().toLowerCase().charAt(0);
      }
   
      if (orderInput == 'a') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getAverageVolume() > x[j+1].getAverageVolume()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      
      else if (orderInput == 'b') {
         for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
               if (x[j].getAverageVolume() < x[j+1].getAverageVolume()) {
                  sub = x[j];
                  x[j]= x[j+1];
                  x[j+1] = sub;
               }
            }
         }
      }
      System.out.println("Sort Complete.");
      return x;
   }


   private static void editData(Company[] x)
   {
      Scanner sc = new Scanner(System.in);
      String company = "", newString = "";
      Boolean available1 = false;
      char option = ' ';
      int newInt = 0;
      double newDouble = 0;
   
      System.out.print("\nInput Company Name: ");
      company = sc.nextLine();
   
      for (int j = 0; j < x.length; j++) {
         if (x[j].getCompanyName().toLowerCase().contains(company) == true) {
            available1 = true;
         }
      }
   
      while (available1 == false) {
         System.out.print("\nCompany Not Found.\n\nInput Company Name: ");
         company = sc.nextLine().toLowerCase();
      
         for (int k = 0; k < x.length; k++) {
            if (x[k].getCompanyName().toLowerCase().contains(company) == true) {
               available1 = true;
            }
         }
      }
   
      do {
         System.out.println("\nChoose One to Edit:");
         System.out.println("a. Company Name\nb. Company Symbol\nc. Year\nd. First Quarter Revenue (in thousands)\ne. Second Quarter Revenue (in thousands)\nf. Third Quarter Revenue (in thousands)\ng. Fourth Quarter Revenue\nh. Yearly Revenue (in thousands)\ni. Gross Profit (in thousands)\nj. Net Income (in thousands)\nk. Date\nl. Average Volume (10-Day)\nm. Stock Price\nn. Stop");
         System.out.print("Choose One: ");
         option = sc.nextLine().toLowerCase().charAt(0);
      
         while (option != 'a' && option != 'b' && option != 'c' && option != 'd' && option != 'e' && option != 'f' && option != 'g' && option != 'h' && option != 'i' && option != 'j' && option != 'k' && option != 'l' && option != 'm' && option != 'n') {
            System.out.println("\nInput Invalid.");
            System.out.println("\nChoose One to Edit:");
            System.out.println("a. Company Name\nb. Company Symbol\nc. Year\nd. First Quarter Revenue (in thousands)\ne. Second Quarter Revenue (in thousands)\nf. Third Quarter Revenue (in thousands)\ng. Fourth Quarter Revenue\nh. Yearly Revenue (in thousands)\ni. Gross Profit (in thousands)\nj. Net Income (in thousands)\nk. Date\nl. Average Volume (10-Day)\nm. Stock Price\nn. Stop");
            System.out.print("Choose One: ");
            option = sc.nextLine().toLowerCase().charAt(0);
         }
      
         if (option == 'a') {
            System.out.print("\nInput new Company Name: ");
            newString = sc.nextLine();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setCompanyName(newString);
               }
            }
         }
         
         else if (option == 'b') {
            System.out.print("\nInput new Company Symbol: ");
            newString = sc.nextLine();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setCompanySymbol(newString);
               }
            }
         }
         
         else if (option == 'c') {
            System.out.print("\nInput new Year: ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setYear(newInt);
               }
            }
         }
         
         else if (option == 'd') {
            System.out.print("\nInput new First Quarter Revenue (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setFirstQuarterRevenue(newInt);
               }
            }
         }
         
         else if (option == 'e') {
            System.out.print("\nInput new Second Quarter Revenue (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setSecondQuarterRevenue(newInt);
               }
            }
         }
         
         else if (option == 'f') {
            System.out.print("\nInput new Third Quarter Revenue (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setThirdQuarterRevenue(newInt);
               }
            }
         }
         
         else if (option == 'g') {
            System.out.print("\nInput new Fourth Quarter Revenue (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setFourthQuarterRevenue(newInt);
               }
            }
         }
         
         else if (option == 'h') {
            System.out.print("\nInput new Yearly Revenue (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setYearlyRevenue(newInt);
               }
            }
         }
         
         else if (option == 'i') {
            System.out.print("\nInput new Gross Profit (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setGrossProfit(newInt);
               }
            }
         }
         
         else if (option == 'j') {
            System.out.print("\nInput new Net Income (in thousands): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setNetIncome(newInt);
               }
            }
         }
         
         else if (option == 'k') {
            System.out.print("\nInput new Date: ");
            newString = sc.nextLine();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setDate(newString);
               }
            }
         }
         
         else if (option == 'l') {
            System.out.print("\nInput new Average Volume (10-Day): ");
            newInt = sc.nextInt();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setAverageVolume(newInt);
               }
            }
         }
         
         else if (option == 'm') {
            System.out.print("\nInput new Stock Price: ");
            newDouble = sc.nextDouble();
            for (int i = 0; i < x.length; i++) {
               if (x[i].getCompanyName().toLowerCase().contains(company) == true) {
                  x[i].setStockPrice(newDouble);
               }
            }
         }
         if (option == 'n') {
            break;
         }
         sc.nextLine();
      }
      
      while (option != 'n');
   }


   private static void addData(Company[] x) throws Exception
   {
      Scanner sc = new Scanner(System.in);
      String company = "", newString = "", filename = "", linesNumberFile = "LinesNumber.txt";
      int newInt = 0, objectNumber = x.length;
      double newDouble = 0;
      
      System.out.print("\nInput file to add companies to: ");
      filename = sc.nextLine();
      
      PrintWriter outputFile = new PrintWriter(filename);
   
      for (int i = 0; i < x.length; i++) {
         newString = x[i].getCompanyName();
         outputFile.printf("%s\n", newString);
      
         newString = x[i].getCompanySymbol();
         outputFile.printf("%s\n", newString);
         
         newInt = x[i].getYear();
         outputFile.printf("%d\n", newInt);
         
         newInt = x[i].getFirstQuarterRevenue();
         outputFile.printf("%d\n", newInt);
         
         newInt = x[i].getSecondQuarterRevenue();
         outputFile.printf("%d\n", newInt);
         
         newInt = x[i].getThirdQuarterRevenue();
         outputFile.printf("%d\n", newInt);
         
         newInt = x[i].getFourthQuarterRevenue();
         outputFile.printf("%d\n", newInt);
         
         newInt = x[i].getGrossProfit();
         outputFile.printf("%d\n", newInt);
         
         newInt = x[i].getNetIncome();
         outputFile.printf("%d\n", newInt);
         
         newString = x[i].getDate();
         outputFile.printf("%s\n", newString);
         
         newInt = x[i].getAverageVolume();
         outputFile.printf("%d\n", newInt);
         
         newDouble = x[i].getStockPrice();
         outputFile.printf("%.2f\n", newDouble);
      }
   
      System.out.print("\nInput Company Name: ");
      newString = sc.nextLine();
      outputFile.printf("%s\n", newString);
         
      System.out.print("\nInput Company Symbol: ");
      newString = sc.nextLine();
      outputFile.printf("%s\n", newString);
         
      System.out.print("\nInput Year: ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput First Quarter Revenue  (in thousands): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Second Quarter Revenue (in thousands): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Third Quarter Revenue (in thousands): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Fourth Quarter Revenue (in thousands): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Gross Profit (in thousands): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Net Income (in thousands): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Date: ");
      sc.nextLine();
      newString = sc.nextLine();
      outputFile.printf("%s\n", newString);
         
      System.out.print("\nInput Average Volume (10-Day): ");
      newInt = sc.nextInt();
      outputFile.printf("%d\n", newInt);
         
      System.out.print("\nInput Stock Price: ");
      newDouble = sc.nextDouble();
      outputFile.printf("%.2f\n", newDouble);
   
      objectNumber = objectNumber + 1;
   
      outputFile.close();
      
      System.out.println("New Company has been added. (Program must be re-run to show changes!)");
      
      PrintWriter outputLinesNumberFile = new PrintWriter(linesNumberFile);
   
      outputLinesNumberFile.printf("%d\n", objectNumber);
      
      outputLinesNumberFile.close();
   }
}