package com.mafn.movie_libary;

import java.util.Scanner;

import com.mafn.movie_libary.domain.models.Movie;
import com.mafn.movie_libary.service.MovieService;
public class App 
{
	private static final Scanner SCAN = new Scanner(System.in);
    public static void main( String[] args )
    {
    	menu();
    	
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
    		System.out.println("[5] READ A MOVIE by TITLE");
    		System.out.println("[6] READ A MOVIE by ID");
    		System.out.println("[7] EXIT");
    		op = Integer.parseInt(SCAN.nextLine());
    		switch(op) {
    		case 1 :
				MovieService.save();
    			break;
    		case 2: 
    			MovieService.readAll();
    			MovieService.delete();
    			break;
    		case 3:
    			MovieService.update();
    		case 4:
    			MovieService.readAll().forEach(System.out::println);
    			break;
    		case 5:
    			MovieService.readByTitle().forEach(System.out::println);
    			break;
    		case 6:
    			MovieService.readById();
    			break;
    		case 7:
    			menuOpen = false;
    			System.out.println("See you later!");
    			break;
    			default : 
    				System.out.println("Sorry , this option was not found!");
    				break;
    		}
    	}
    }

	
}
