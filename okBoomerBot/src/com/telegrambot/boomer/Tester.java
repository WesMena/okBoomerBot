/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telegrambot.boomer;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.BotSession;

/**
 *
 * @author wesli
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
  
        
        
        public static void main(String[] args) {
       
        boomerBot boomer=new boomerBot();
         boomer.start();
                
               // telegramBotsApi.registerBot(new boomerBot());
            
          
        }
    
    
}
