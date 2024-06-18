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
    		System.out.println("[5] EXIT");
    		op = Integer.parseInt(SCAN.nextLine());
    		switch(op) {
    		case 1 :
				MovieService.save(Movie.createMovie());
    			break;
    		case 2: 
    			MovieService.read();
    			System.out.println("Type the id of the movie:");
    			MovieService.delete(Integer.valueOf(SCAN.nextLine()));
    			break;
    		case 3:
    			System.out.println("Update your movie by id:");
    			MovieService.read();
    			Integer id = Integer.parseInt(SCAN.nextLine());;
    			Movie movieUpdate = Movie.createMovie();
    			movieUpdate.setId(id);
    			MovieService.update(movieUpdate);
    		case 4:
    			MovieService.read().forEach(System.out::println);
    			break;
    		case 5:
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
