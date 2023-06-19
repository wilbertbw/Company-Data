public class Company
{
   protected String companyName;
   protected String companySymbol;
   protected int year;
   protected int firstQuarterRevenue;
   protected int secondQuarterRevenue;
   protected int thirdQuarterRevenue;
   protected int fourthQuarterRevenue;
   protected int yearlyRevenue;
   protected int grossProfit;
   protected int netIncome;
   protected String date;
   protected int averageVolume;
   protected double stockPrice;

   // Constructor
   Company(String companyName, String companySymbol, int year, int firstQuarterRevenue, int secondQuarterRevenue, int thirdQuarterRevenue, int fourthQuarterRevenue, int grossProfit, int netIncome, String date, int averageVolume, double stockPrice)
   {
      this.companyName = companyName;
      this.companySymbol = companySymbol;
      this.year = year;
      this.firstQuarterRevenue = firstQuarterRevenue;
      this.secondQuarterRevenue = secondQuarterRevenue;
      this.thirdQuarterRevenue = thirdQuarterRevenue;
      this.fourthQuarterRevenue = fourthQuarterRevenue;
      this.yearlyRevenue = 0;
      this.grossProfit = grossProfit;
      this.netIncome = netIncome;
      this.date = date;
      this.averageVolume = averageVolume;
      this.stockPrice = stockPrice;
   }
   
   
   // Accessor
   public String getCompanyName()
   {
      return companyName;
   }
   
   public String getCompanySymbol()
   {
      return companySymbol;
   }
   
   public int getYear()
   {
      return year;
   }

   public int getFirstQuarterRevenue()
   {
      return firstQuarterRevenue;
   }

   public int getSecondQuarterRevenue()
   {
      return secondQuarterRevenue;
   }

   public int getThirdQuarterRevenue()
   {
      return thirdQuarterRevenue;
   }

   public int getFourthQuarterRevenue()
   {
      return fourthQuarterRevenue;
   }

   public int getYearlyRevenue()
   {
      return yearlyRevenue;
   }

   public int getGrossProfit()
   {
      return grossProfit;
   }

   public int getNetIncome()
   {
      return netIncome;
   }

   public String getDate()
   {
      return date;
   }

   public int getAverageVolume()
   {
      return averageVolume;
   }

   public double getStockPrice()
   {
      return stockPrice;
   }
   

   // Mutator
   public void setCompanyName(String companyName)
   {
      this.companyName = companyName;
   }

   public void setCompanySymbol(String companySymbol)
   {
      this.companySymbol = companySymbol;
   }

   public void setYear(int year)
   {
      this.year = year;
   }

   public void setFirstQuarterRevenue(int firstQuarterRevenue)
   {
      this.firstQuarterRevenue = firstQuarterRevenue;
   }

   public void setSecondQuarterRevenue(int secondQuarterRevenue)
   {
      this.secondQuarterRevenue = secondQuarterRevenue;
   }

   public void setThirdQuarterRevenue(int thirdQuarterRevenue)
   {
      this.thirdQuarterRevenue = thirdQuarterRevenue;
   }

   public void setFourthQuarterRevenue(int fourthQuarterRevenue)
   {
      this.fourthQuarterRevenue = fourthQuarterRevenue;
   }

   public void setYearlyRevenue(int yearlyRevenue)
   {
      this.yearlyRevenue = yearlyRevenue;
   }

   public void setGrossProfit(int grossProfit)
   {
      this.grossProfit = grossProfit;
   }

   public void setNetIncome(int netIncome)
   {
      this.netIncome = netIncome;
   }

   public void setDate(String date)
   {
      this.date = date;
   }

   public void setAverageVolume(int averageVolume)
   {
      this.averageVolume = averageVolume;
   }

   public void setStockPrice(double stockPrice)
   {
      this.stockPrice = stockPrice;
   }


   // Calculations
   public void calculateYearlyRevenue()
   {
      this.yearlyRevenue = firstQuarterRevenue + secondQuarterRevenue + thirdQuarterRevenue + fourthQuarterRevenue;
   }

   public void calculateNewStockPrice(double percentChange)
   {
      this.stockPrice = ((percentChange + 100) / 100) * stockPrice;
   }
}
