
package statisticsprogram;

import java.util.Arrays;
import java.util.Scanner;
public class StatisticsProgram {
    
    static boolean dataSet=false;
    
    //mean kısmını diğer methodlarda kullanabilmek için
    
    static double avgA,avgB,avgC;
    static double varianceA,varianceB,varianceC;
    
    //en başta arrayleri oluşturduk her metotta kullanabilmek için
    static int dig1,dig2,dig3,dig4;
    static int[]setA=new int[12];
    static int[]setB=new int[12];
    static int[]setC=new int[12];
    
    public static void main(String[] args){  
        Scanner input=new Scanner(System.in);
       
        enterStudentID();
        
         while (true) {
        System.out.println("\n-------- Statistics Program Menu --------");
        System.out.println("1) Print data sets");
        System.out.println("2) Compute mean");
        System.out.println("3) Compute median");
        System.out.println("4) Compute variance");
        System.out.println("5) Compute standard deviation");
        System.out.println("6) Compute variance-covariance matrix");
        System.out.println("7) Compute correlation coefficient");
        System.out.println("8) Quit");
        System.out.print("Please enter your choice [1-8]: ");

        int choice = input.nextInt();

            switch (choice) {
                case 1:
                    printDataSets();
                    break;
                case 2:
                    computeMean();
                    break;
                case 3:
                    computeMedian();
                    break;
                case 4:
                    computeVariance();
                    break;
                case 5:
                    computeStandardDeviation();
                    break;
                case 6:
                    computeVarianceCovarianceMatrix(); 
                    break;
                case 7:
                    computeCorrelationCoefficient();  
                    break;
                case 8:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
      }
        
    }
    
    public static void enterStudentID(){
        Scanner input=new Scanner(System.in);
        String studentID;
        
      while(true){
          System.out.println("Enter your Student ID"
                  + "(like Isık University format):    ");
          studentID=input.nextLine();
          studentID=studentID.toUpperCase();
          
          if(studentID.length()==10 && 
                  Character.isDigit(studentID.charAt(6))&&
                  Character.isDigit(studentID.charAt(7))&&
                  Character.isDigit(studentID.charAt(8))&&
                  Character.isDigit(studentID.charAt(9))){
              
              dig4=studentID.charAt(6)-'0';
              dig3=studentID.charAt(7)-'0';
              dig2=studentID.charAt(8)-'0';
              dig1=studentID.charAt(9)-'0';   
              break;
              
          }else{
              System.out.println("Invalid Student ID! Try again.");
          }
      }
       
    }
            
      public static void printDataSets(){
          
        //set a için 4 rakam tekrar edicek
        
        for(int i=0;i<12;i++){
             int seri=i%4;
            
            if (seri==0)setA[i]=dig1;
            else if(seri==1)setA[i]=dig2;
            else if(seri==2)setA[i]=dig3;
            else if(seri==3)setA[i]=dig4;
            
        }
        
        //setb için aynı rakamdan 3 tane
         for(int i=0;i<12;i++){
             
             if(i<3)setB[i]=dig1;
             else if(i<6)setB[i]=dig2;
             else if(i<9)setB[i]=dig3;
             else setB[i]=dig4;
         }
          
         //setC için a setinin ters hali olucak şekilde 
         
         for(int i=0;i<12;i++){
             int seri=i%4;
            
            if (seri==0)setC[i]=dig4;
            else if(seri==1)setC[i]=dig3;
            else if(seri==2)setC[i]=dig2;
            else if(seri==3)setC[i]=dig1;
         }
         
         //print aşaması
         
         System.out.println("Set A:    ");
         for(int i=0;i<setA.length;i++){
             System.out.print(setA[i]+ " ");
            
         }
         System.out.println();
         
         System.out.println("Set B:    ");
         for(int i=0;i<setB.length;i++){
             System.out.print(setB[i]+ " ");
         }
         System.out.println();
         
         System.out.println("Set C:    ");
         for(int i=0;i<setC.length;i++){
             System.out.print(setC[i]+ " ");
             
         }
         
         dataSet=true;
          
      }
      
      public static void computeMean(){
       if (!dataSet) {
        System.out.println("Please generate data sets first (Option 1).");
        return;
        }   
           
       double sumA=0;
       double sumB=0;
       double sumC=0;
       
       for(int i=0;i<12;i++){
           
          sumA+=setA[i]; 
          sumB+=setB[i];  
          sumC+=setC[i];  
           
       }
       
        avgA=sumA/12;
        avgB=sumB/12;
        avgC=sumC/12;
       
       
       System.out.println("Average of Set A:   " +avgA);
       System.out.println("Average of Set B:   " +avgB); 
       System.out.println("Average of Set C:   " +avgC);   
          
         
      }
      
      public static void computeMedian(){
          if (!dataSet) {
        System.out.println("Please generate data sets first (Option 1).");
        return;
         }    
          
          //önce arrayleri kopyalamamız lazım
          
          int[] copyA=new int[12];
          int[] copyB=new int[12];
          int[] copyC=new int[12];
          
          for (int i=0;i<12;i++){
              
               copyA[i]=setA[i];
               copyB[i]=setB[i];
               copyC[i]=setC[i];
          }
          
          //medianı bulmamız için önce sıralamamız lazım 
          Arrays.sort(copyA);
          Arrays.sort(copyB);
          Arrays.sort(copyC);
          
          //çift sayıda eleman olduğu için 5ve6ları alıp ikiye bölmemiz yeterli
          
          
          double medianA=(copyA[5]+copyA[6])/2.0;
          double medianB=(copyB[5]+copyB[6])/2.0;
          double medianC=(copyC[5]+copyC[6])/2.0;
          
          
          //display
          
          System.out.println("Median of Set A: "+medianA);
          System.out.println("Median of Set B: "+medianB);
          System.out.println("Median of Set C: "+medianC);
          
          
      }
      
      public static void computeVariance(){
           if (!dataSet) {
        System.out.println("Please generate data sets first (Option 1).");
        return;
          }   
          
         //her elemanının ortalamadan farkının karesini alıp toplıcaz
         //sonrasında 11 e bölücez toplam elemanın bir eksiği
         
         double squareA=0;
         double squareB=0;
         double squareC=0;
         
         for(int i=0;i<12;i++){
             
             squareA+=Math.pow(setA[i]-avgA,2);
             squareB+=Math.pow(setB[i]-avgB,2);
             squareC+=Math.pow(setC[i]-avgC,2);
         }
          
          varianceA=squareA/11;
          varianceB=squareB/11;
          varianceC=squareC/11;
          
          
          //display
          
          System.out.println("Variance of Set A: "+varianceA);
          System.out.println("Variance of Set B: "+varianceB);
          System.out.println("Variance of Set C: "+varianceC);
      }
      
       public static void computeStandardDeviation(){
            if (!dataSet) {
        System.out.println("Please generate data sets first (Option 1).");
        return;
         }   
        
           double deviA=Math.sqrt(varianceA);
           double deviB=Math.sqrt(varianceB);
           double deviC=Math.sqrt(varianceC);
           
           System.out.println("Standard Deviation of Set A: "+deviA);
           System.out.println("Standard Deviation of Set B: "+deviB);
           System.out.println("Standard Deviation of Set C: "+deviC);
       }
            
        public static void computeVarianceCovarianceMatrix(){
             if (!dataSet) {
        System.out.println("Please generate data sets first (Option 1).");
        return;
         }   
          
            //9 tane değişken tanımlıyoruz
            double sAA=0,sAB=0,sAC=0;
            double sBB=0,sBC=0;
            double sCC=0;
            
          //setleri meanlerinden çıkarıp çarpıyoruz her olasılığı oluşturuyoruz
            
           for(int i=0;i<12;i++){
               
             sAA+=(setA[i]-avgA)*(setA[i]-avgA);  
             sAB+=(setA[i]-avgA)*(setB[i]-avgB);  
             sAC+=(setA[i]-avgA)*(setC[i]-avgC);  
             sBB+=(setB[i]-avgB)*(setB[i]-avgB);  
             sBC+=(setB[i]-avgB)*(setC[i]-avgC);  
             sCC+=(setC[i]-avgC)*(setC[i]-avgC);
             
           } 
            //şimdi bulunan değerler n-1 yani 11 e bölünecek
            
             sAA/= 11;
             sAB/= 11;
             sAC/= 11; 
             sBB/= 11;
             sBC/= 11;
             sCC/= 11;
            
             //bunları arraye yerleştiriyouz
             
             double[]Qxx=new double[9];
             
             Qxx[0]=sAA;
             Qxx[1]=sAB;
             Qxx[2]=sAC;
             Qxx[3]=sAB;
             Qxx[4]=sBB;
             Qxx[5]=sBC;
             Qxx[6]=sAC;
             Qxx[7]=sBC;
             Qxx[8]=sCC;
             
             System.out.println("Variance Covariance Matrix(Qxx):");
             
             for(int i=0;i<9;i++){
                 System.out.println("\n "+Qxx[i]);
             }
                     
             System.out.println();
             
            
        }
            
          
        public static void computeCorrelationCoefficient(){
            if (!dataSet) {
        System.out.println("Please generate data sets first (Option 1).");
        return;
    }    
          //kovaryans değerini önceki metodttaki gibi uygulıuyoruz. 
           double sAB=0,sAC=0,sBC=0;
           
           for(int i=0;i<12;i++){
               
               sAB+=(setA[i]-avgA)*(setB[i]-avgB);
               sAC+=(setA[i]-avgA)*(setC[i]-avgC);
               sBC+=(setB[i]-avgB)*(setC[i]-avgC);
               
           }
            // n-1 e bölüyoruz
            sAB/=11;
            sAC/=11;
            sBC/=11;
            
            //karekök alma
            
           double deviA=Math.sqrt(varianceA);
           double deviB=Math.sqrt(varianceB);
           double deviC=Math.sqrt(varianceC);
            
            
            //korelasyon hesaplama
            
            double rAB=sAB/(deviA*deviB);
            double rAC=sAC/(deviA*deviC);
            double rBC=sBC/(deviB*deviC);
            
            
            //array oluşturma
            
            double[]Rxx=new double[9];
            
            Rxx[0]=1.0;
            Rxx[1]=rAB;
            Rxx[2]=rAC;
            Rxx[3]=rAB;
            Rxx[4]=1.0;
            Rxx[5]=rBC;
            Rxx[6]=rAC;
            Rxx[7]=rBC;
            Rxx[8]=1.0;
            
            System.out.println("Correlation Coefficient Matrix(Rxx):");
             
             for(int i=0;i<9;i++){
                 System.out.println("\n "+Rxx[i]);
             }
                     
             System.out.println();
            
            
        }
        
        public static void quit(){
            
            System.out.println("Exiting the program.");
            System.exit(0);
        }
}
