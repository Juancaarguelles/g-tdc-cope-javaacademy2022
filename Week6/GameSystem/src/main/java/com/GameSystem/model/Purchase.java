package com.GameSystem.model;

import javax.persistence.*;

@Entity
public class Purchase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_purchase;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_game", nullable = false)
    private Game game;

    public Purchase(){}

    public Purchase(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public Integer getId_purchase() {
        return id_purchase;
    }

    public void setId_purchase(Integer id_purchase) {
        this.id_purchase = id_purchase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
