/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrupagereplacement;

import java.util.Scanner;

/**
 *
 * @author bobos
 */
public class LRUpageReplacement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc=new Scanner(System.in);

  System.out.println("enter number of frames");
  int framesize=sc.nextInt();
  System.out.println("enter number of pages");
  int nr=sc.nextInt();
  int page[]=new int[nr];
  int frame[]=new int[nr];
  
 System.out.println("enter pages");
  for(int i=0;i<nr;i++)
  page[i]=sc.nextInt()
          ;
  for(int i=0;i<framesize;i++)
  frame[i]=-1;
  
  for(int k=0;k<framesize;k++)
  System.out.print(" "+frame[k]);
  System.out.println()
          ;
  int flag=0,hit=0,fault=0,front=0,rear=-1;
  int age[]=new int[framesize];
  for(int i=0;i<framesize;i++)
  age[i]=0;
  for(int j=0,i=0;j<framesize && i<nr;j=j%framesize,i++)
  {
    flag=0;
     
    for(int y=0;y<framesize;y++)
    {
    if(frame[y]==page[i])
    {
     flag=1;
     hit++;
     age[y]=0; 
    }
    }
    if(flag==0)
    if(frame[j]==-1)
    { 
 
     frame[j]=page[i];
     fault++;
     rear++;
     j++;
    }
    else
     
    {
     int max=age[0],loc=0;
     fault++;


     for(int b=0;b<framesize;b++)
     if(age[b]>max)
     {
     max=age[b];loc=b;
     }
     frame[loc]=page[i];
     age[loc]=0;
     j++;
                                           } 
   for(int k=0;k<framesize;k++)
   System.out.print(" "+frame[k]);
   System.out.println();
   for(int a=0;a<framesize;a++)
     {
     if(frame[a]==-1)
     age[a]=0;
     else
     age[a]++;
     }
   

  }
  
  System.out.println("hits="+hit+" faults="+fault);
  
 }
    
    }
    

