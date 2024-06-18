package com.mafn.movie_libary;

import java.util.Scanner;

import com.mafn.movie_libary.service.MovieService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App 
{
	private static final Scanner SCAN = new Scanner(System.in);
    public static void main( String[] args )
    {
    	
    
    }
    
    
    public static void menu() {
    	boolean menuOpen = true;
    	Integer op = 0;
    	while(menuOpen) {
    		System.out.println("Type the number of your operation:");
    		System.out.println("[1] SAVE A MOVIE");
    		System.out.println("[2] DELETE A MOVIE");
    		System.out.println("[3] UPDATE A MOVIE");
    		System.out.println("[4] READ ALL MOVIES");
    		System.out.println("[5] EXIT");
    		
    	}
    }

	
}
