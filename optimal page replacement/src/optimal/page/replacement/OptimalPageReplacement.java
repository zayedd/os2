/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimal.page.replacement;

import java.util.Scanner;

/**
 *
 * 
 */
public class OptimalPageReplacement {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int framesize = 0;
        int pointer = 0;
        int faultnum = 0;
        int pagesize;
        boolean isFull = false;
     
       
      
       
        

        System.out.println("enter the number of frames: ");
        framesize = Integer.parseInt(in.nextLine());

        System.out.println("enter the number of pages: ");
        pagesize = Integer.parseInt(in.nextLine());

        int pages[] = new int[pagesize];
       int  mem_layout[][] = new int[pagesize][framesize];
           int frames[] = new int[framesize];
       boolean hit[] = new boolean[pagesize];
       int fault[] = new int[pagesize];
        for(int j = 0; j < framesize; j++)
        {
            frames[j] = -1;
        }

        System.out.println(" enter the pages: ");
        for(int i = 0; i < pagesize; i++)
        {
            pages[i] = Integer.parseInt(in.nextLine());
        }
        System.out.println();
        for(int i = 0; i < pagesize; i++)
        {
            int search = -1;
            for(int j = 0; j < framesize; j++)
            {
                if(frames[j] == pages[i])
                {
                    search = j;
                    hit[i] = true;
                    fault[i] = faultnum;
                    break;
                }
            }

            if(search == -1)
            {
                if(isFull)
                {
                    int index[] = new int[framesize];
                    boolean index_flag[] = new boolean[framesize];
                    for(int j = i + 1; j < pagesize; j++)
                    {
                        for(int k = 0; k < framesize; k++)
                        {
                            if((pages[j] == frames[k]) && (index_flag[k] == false))
                            {
                                index[k] = j;
                                index_flag[k] = true;
                                break;
                            }
                        }
                    }
                    int max = index[0];
                    pointer = 0;
                    if(max == 0)
                    {
                        max = 200;
                    }

                    for(int j = 0; j < framesize; j++)
                    {
                        if(index[j] == 0)
                        {
                            index[j] = 200;
                        }

                        if(index[j] > max)
                        {
                            max = index[j];
                            pointer = j;
                        }
                    }
                }
                frames[pointer] = pages[i];
                faultnum++;
                fault[i] = faultnum;
                if(!isFull)
                {
                    pointer++;
                    if(pointer == framesize)
                    {
                        pointer = 0;
                        isFull = true;
                    }
                }
            }

            for(int j = 0; j < framesize; j++)
            {
                mem_layout[i][j] = frames[j];
            }
        }

        for(int i = 0; i < pagesize; i++)
        {
            System.out.print(pages[i] + ": Memory is: ");
            for(int j = 0; j < framesize; j++)
            {
                if (mem_layout[i][j] == -1)
                {
                    System.out.printf( "-1");
                } else
                {
                    System.out.printf("%3d ", mem_layout[i][j]);
                }
            }
            System.out.print(": ");
            if (hit[i]) {
                System.out.print("hit");
            } else
            {
                System.out.print("fault");
            }
            System.out.print(": (Number of Page Faults: " + fault[i] + ")");
            System.out.println();
        }
        System.out.println("Total Page Faults: " + faultnum);
    }
    }
    