
package page.replacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
// Youssef Mohamed Ali & Ahmed Hesham Samir
 
public class PageReplacement {
    
     
 static void fifo(int framesize,int pagesize,int pages[]  ){

 int k=0,fault=0,hits=0;
     int frames[]=new int[framesize];
       for(int f=0;f<framesize;f++)
       {
           frames[f]=-1;
       }
       boolean same;
      for(int p=0;p<pagesize;p++)
                {
                        same=false;


                                for(int f=0;f<framesize;f++)
                                if(frames[f]==pages[p])
                                {
                                        same=true;
                                        hits+=1;
                                        System.out.println("HIT(No page replacement)");
                                }
                                if(same==false)
                                {
                                        frames[k]=pages[p];
                                        k++;
                                        if(k>=framesize)
                                        k=0;
                                        fault=fault+1;
                                        System.out.println("Page fault");
                                }
                       for(int z=0;z<framesize;z++)
              {
                  System.out.println(frames[z]);
                  if(z==framesize-1)
                      System.out.println("*--*--*--*--*--*");
                  
              }
                }
      System.out.println("Hits:"+hits+"  Faults:"+fault);
       }
   
 
    
    public static void main(String[] args) throws IOException {
      
        int fs,ps;
           BufferedReader lr =new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Insert the no. of frames :");
               fs=Integer.parseInt(lr.readLine());     
                System.out.println("Insert the no. of inputs :");
                 ps=Integer.parseInt(lr.readLine());
             int p[]=new int[ps];
                System.out.println("Insert inputs:");
            
               
      for(int m=0;m<ps;m++)
       {
           p[m]=Integer.parseInt(lr.readLine());
       }
      System.out.println("---------------");
        fifo(fs, ps, p);
        

}
}
