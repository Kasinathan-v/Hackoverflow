package com.beerDistribution;

import java.util.ArrayList;
import java.util.Scanner;

public class hackoverflow {
	static int count = 1;

	public static void main(String args[]) {
		int startinv = 1;
		int dcstartinv = 1;
		int dcbacklog = 0;
		int sum = 0, avg = 0, sum1 = 0, avg1 = 0;
		int check = 0;
		ArrayList<Integer> rdeman = new ArrayList<Integer>();
		ArrayList<Integer> ddeman = new ArrayList<Integer>();
		while (true) {

			Scanner obj = new Scanner(System.in);

			System.out.println("retailer demand:");
			int demand = obj.nextInt();
			rdeman.add(demand);
			sum = sum + demand;

			avg = sum / rdeman.size();
			System.out.println(avg);
			if (count == 1) {
				System.out.println("starting inventory of retailer:");
				startinv = obj.nextInt();
				System.out.println("starting inventory of dc:");
				dcstartinv = obj.nextInt();
			}
// if(count!=1)
// {
// demand=demand+dcbacklog;
// }
			int d1 = demand / 2;
			int d2 = demand;
			int d3 = demand + (demand / 2);

			dc dec = new dc(d2, startinv, d1, d3, dcstartinv, dcbacklog, avg, avg1);
			check++;
			// System.out.println("hi da "+startinv);
			startinv = dec.endinv + dec.dcfullfilled;
			dcstartinv = dec.dcendinv + dec.dcorder;
			dcbacklog = dec.dcbacklog;
			ddeman.add(dec.dcdemand);
			sum1 = sum1 + dec.dcdemand;
			avg1 = sum1 / ddeman.size();
			// System.out.println(ddeman);

			count++;
			System.out.println();

		}

	}
}