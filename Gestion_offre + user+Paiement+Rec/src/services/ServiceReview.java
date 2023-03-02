/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import entities.Review;
import entities.Transaction;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DataSource;

/**
 *
 * @author Ghass
 */
public class ServiceReview implements IService <Review> {
    
    Connection cnx = DataSource.getInstance().getCnx();
     @Override
    public void ajouter(Review c) {
        try {
            String req = "INSERT INTO review (id_editeur, id_user,message,note) VALUES ('" + c.getId_editeur().getId()+ "', '" + c.getId_user().getId()+ "','" + c.getMessage() + "','" + c.getNote() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("card created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM review WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Transaction deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     @Override
    public void modifier(Review c) {
        try {
            String req = "UPDATE review SET id_editeur = '" + c.getId_editeur().getId() + "', id_user = '" + c.getId_user().getId() + "', message = '" + c.getMessage() + "',note = '" + c.getNote() + "'  WHERE review.id = " + c.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("card updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public List<Review> getAll() {
        List<Review> list = new ArrayList<>();
        try {
            String req = "Select * from review";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                ServiceUser sw = new ServiceUser();
                Utilisateur ud,u;
                
                u=sw.getOneById(rs.getInt("id_user"));
                ud=sw.getOneById(rs.getInt("id_editeur"));
                Review c = new Review(rs.getInt(1), ud,u,rs.getString("message"), rs.getFloat("note"));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    @Override
    public Review getOneById(int id) {
        Review c = null;
        try {
            String req = "Select * from review WHERE review.id ='"+id+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                 ServiceUser sw = new ServiceUser();
                Utilisateur ud,u;
                
                u=sw.getOneById(rs.getInt("id_user"));
                ud=sw.getOneById(rs.getInt("id_editeur"));
                c = new Review(rs.getInt(1), ud,u,rs.getString("message"), rs.getFloat("note"));
                
              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }
    
    
}
