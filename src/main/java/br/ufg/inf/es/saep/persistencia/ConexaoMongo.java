/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.persistencia;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 *
 * @author JuliannyAS
 */
public class ConexaoMongo {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "simple-mongodb";

    private static ConexaoMongo uniqInstance;
    private static int mongoInstance = 1;

    private Mongo mongo;
    private DB db;

    private ConexaoMongo() {
        //construtor privado
    }

    //garante sempre uma unica instancia
    public static synchronized ConexaoMongo getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new ConexaoMongo();
        }
        return uniqInstance;
    }

    //garante um unico objeto mongo
    public DB getDB() {
        if (mongo == null) {
            mongo = new Mongo(HOST, PORT);
            db = mongo.getDB(DB_NAME);
            System.out.println("Mongo instance equals :> " + mongoInstance++);
        }
        return db;
    }
}
