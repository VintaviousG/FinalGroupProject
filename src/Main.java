import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What day is it");
        String day = scanner.nextLine();

        //Tells the user how much data CSS needs sorting on that day
        switch (day) {
            case "Monday":
                System.out.println("Its Monday we should sort: 10,000,000 records");
                break;
            case "Tuesday":
                System.out.println("Tuesday we should sort: 1,000,000 records");
                break;
            case "Wednesday":
                System.out.println("Wednesday we should sort: 30,000,000");
                break;
            case "Thursday":
                System.out.println("Thursday we should sort: 50,000,000");
                break;
            case "Friday":
                System.out.println("Friday we should sort:  500,000 records");
                break;
            case "Saturday":
                System.out.println("Saturday we should sort: 100,000,000 records");
                break;
            case "Sunday":
                System.out.println("Sunday we should sort:  100,000 records");
                break;
            default:
                System.out.println("Re - enter day like this: Monday");
                System.exit(0);
        }

        System.out.println("Enter in the correct amount of records to sort");
        int numberOfRecords = scanner.nextInt();

        //Tells how mush data we need to sort on the given day
        amountOfData(numberOfRecords);

        //make random interger of array, based on the size of the data amount
        Random num = new Random();
        int [] number = new int [numberOfRecords];
        for (int d = 0 ; d<number.length ; d++){
            int RandomNum = num.nextInt(250)+1;
            number[d] = RandomNum;
           // System.out.print(" " +RandomNum);
        }

        long startTime = System.nanoTime();
        /*Sorts the items on the given day, using the SaaS recommended for that day*/
        switch (day) {
            case "Monday":
                CSSSorting.CSSSortMonday(number);
                System.out.println("AJAX SaaS was used");
                break;
            case "Tuesday":
                CSSSorting.CSSSortTuesday(number);
                System.out.println("ACME SaaS was used");
                break;
            case "Wednesday":

                CSSSorting.CSSSortWednesday(number);
                System.out.println("AJAX SaaS was used");
                break;
            case "Thursday":
                CSSSorting.CSSSortThursday(number);
                System.out.println("AJAX SaaS was used");
                break;
            case "Friday":
                CSSSorting.CSSSortFriday(number);
                System.out.println("ACME SaaS was used");
                break;
            case "Saturday":
                CSSSorting.CSSSortSaturday(number);
                System.out.println("AJAX SaaS was used");
                break;
            case "Sunday":
                CSSSorting.CSSSortSunday(number);
                System.out.println("ACME SaaS was used");
                break;
        }

        long endTime = System.nanoTime();

        long timeInMillis = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);
        System.out.println("Sort Time in ms: " + timeInMillis);

        long seconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis);
        System.out.println("Sort time in seconds: " + seconds);


        //ON THESE DAYS CALCULATE THE AJAX COST ONLY
        if(day.equals("Monday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Saturday")){
            AjaxCost(numberOfRecords);

            //ON THESE DAYS CALCULATE THE ACME COST ONLY
        } else if (day.equals("Tuesday") || day.equals("Friday") || day.equals("Sunday") ){
            ACMEMoneyCost(numberOfRecords);
        }

    }

    public static void amountOfData(int record){

        //10,000,000
        switch (record) {
            case 10000000:
                System.out.println("Its Monday great");
                System.out.println("The result are below");

                //1,000,000
                break;
            case 1000000:
                System.out.println("Its Tuesday");
                System.out.println("The result are below");
                //30,000,000
                break;
            case 30000000:
                System.out.println("Its Wednesday");
                System.out.println("The result are below");
                //50,000,000
                break;
            case 50000000:
                System.out.println("Its Thursday");
                System.out.println("The result are below");
                //500,000
                break;
            case 500000:
                System.out.println("Its Friday");
                System.out.println("The result are below");
                //100,000,000
                break;
            case 100000000:
                System.out.println("Its Saturday");
                System.out.println("The result are below");
                //100,000
                break;
            case 100000:
                System.out.println("Its Sunday");
                System.out.println("The result are below");
                break;
            default:
                System.out.println("Wrong number entered");
                System.exit(0);
        }
    }

    public static int upToOneThousand(int Size) {
        // System.out.println(say + "<----------");
        int numberOfItemsToSortPerRequest = 1000;
        int costPerReqest = 700;

        int numberOfRequests = Size / numberOfItemsToSortPerRequest;

        return costPerReqest * numberOfRequests;


    }

    public static int upToOneHundred(int Size) {
        // System.out.println(say + "<----------");
        int numberOfItemsToSortPerRequest = 100;
        int costPerReqest = 1;

        int numberOfRequests = Size / numberOfItemsToSortPerRequest;

        return costPerReqest * numberOfRequests;


    }

    public static int upToMillion(int Size) {
        // System.out.println(say + "<----------");
        int numberOfItemsToSortPerRequest = 1000000;
        int costPerReqest = 13000;

        int numberOfRequests = Size / numberOfItemsToSortPerRequest;
        //30,000,000 / 1,000,000

        return costPerReqest * numberOfRequests;


    }

    public static void AjaxCost(int Size){

        //number of item to be sorted on each request
        int numberOfItemsToSortPerRequest = 1000;
        int costPerReqest = 1000;

        int numberOfRequests = Size / numberOfItemsToSortPerRequest;

        int MoneyCost = numberOfRequests * costPerReqest;

        // if the number of request need to sort is less than the daily request max amount
        if(numberOfRequests <= 100000 ){
            System.out.println("Amount of request need to sort " + Size+ " items is: " + numberOfRequests);
            System.out.println("Money Cost is: " + MoneyCost );

        } else if(numberOfRequests >= 100001 || numberOfRequests <= 1000000){
            costPerReqest = 10000;
            numberOfRequests = Size / numberOfItemsToSortPerRequest;

            MoneyCost = numberOfRequests * costPerReqest;

            System.out.println("Amount of request need to sort " + Size+ " items is: " + numberOfRequests);
            System.out.println("Money Cost is: "  + MoneyCost);


        } else{
            System.out.println("Error");
        }


    }

    public static void ACMEMoneyCost(int x){
        
           if(x <= 100 || x <= 999 ){
     System.out.println(" 1st Array Size is: " + x);
 System.out.println("This should be the MoneyCost of this example = " + "$"+   upToOneHundred(x));
   } else if( x <= 1000 || x <= 1000000){
      System.out.println(" 2nd Array Size is: " + x);
 System.out.println("This should be the MoneyCost of this example = " + "$"+   upToOneThousand(x));
   } else if(x <= 1000000 || x <= 100000000){

          System.out.println(" 3nd Array Size is: " + x);
 System.out.println("This should be the MoneyCost of this example = " + "$"+   upToMillion(x));
   } else{
 System.out.println("Error Occurred");
   }


    }

    public static int ajaxCost(int records){
        int cost,request;
        //each request can hold 1000 records, this will hold how many
        //total request we need to send off
        if(records <= 1000)
            request = 1;
        else
            request = records / 1000;
        // if total request are under 100,000 then at one price
        // if more then that at a different price
        if (request <= 100000){
            cost = request * 1000;
        }
        else{
            cost = request * 10000;
        }
        return cost;
    }


}
