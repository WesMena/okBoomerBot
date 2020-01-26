/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telegrambot.boomer;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.generics.BotSession;

/**
 *
 * @author wesli
 */
public class boomerBot extends TelegramLongPollingBot {
              BotSession session;
TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

static{
   ApiContextInitializer.init();  
}
  
    public void start(){
        //Inicia la sesión
        try{
             this.session=telegramBotsApi.registerBot(this);
             
        }catch(TelegramApiRequestException e){
            e.printStackTrace();
            
        }
    }
    
    
    
    
    public String getBotToken() {
        //Es el token que usa Telegram para autenticar que uno es el dueño del bot.
       return "1070859802:AAG3oyN8z1fZTAGSBqFjkLnCUFJ0ZDzKCjQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
     /*
        Usando el patrón observador, el API dispara un evento de actualización
        cada vez que el usuario envía un mensaje.Según el tipo, usa un objeto del
        tipo SendMessage o SendPhoto(el api sirve para varios más, pero 
        esos son los implementados aquí).
        
        */
       String messageStr=update.getMessage().getText();
       
       SendMessage message =new SendMessage();
       SendPhoto photo=new SendPhoto();
       String msgType="";
       
       
       switch(messageStr){
           case "/start":
               
               message.setText("hey boomer!");
               msgType="text";
               break;
           
           case "/boomer":
                message.setText("ok boomer");
                msgType="text";
               break;
               
           case "/boomerimg":
               photo.setPhoto("https://i.kym-cdn.com/photos/images/original/001/561/371/77e.jpg");
               msgType="photo";
               break;
               
           case "/about":
               message.setText("I was made by WesMena...because he was bored");
               msgType="text";
               break;
               
           case "/sourcecode":
               message.setText("https://github.com/WesMena/okBoomerBot");
               msgType="text";
              
               break;
               
           case "/stop":
               message.setText("Bye boomer!");
               msgType="stop";
       }
       
       
       //Obtiene el id del chat para saber a quien enviar el mensaje
       message.setChatId(update.getMessage().getChatId());
       photo.setChatId(update.getMessage().getChatId());
       
       if(msgType.equalsIgnoreCase("text")){
           
       try{
           
       sendMessage(message);
       
       }catch(TelegramApiException e){
           
           e.printStackTrace();
       }     
       }
      
       if(msgType.equalsIgnoreCase("photo")){
           
         try{
             
       sendPhoto(photo);
       
       }catch(TelegramApiException e){
           
           e.printStackTrace();
           
       }      
       }
      
       
       
       
    }

    @Override
    public String getBotUsername() {
        return "okBoomerBot";
    }

  
    public void onClosing() {
 
     
   
    }
   
    
}
