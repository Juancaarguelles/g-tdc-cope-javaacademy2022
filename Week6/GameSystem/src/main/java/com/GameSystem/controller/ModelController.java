package com.GameSystem.controller;

import com.GameSystem.model.Game;
import com.GameSystem.model.Purchase;
import com.GameSystem.model.User;
import com.GameSystem.service.GameService;
import com.GameSystem.service.PurchaseService;
import com.GameSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModelController {
    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/users")
    public List<User> listAllUsers() {
        return this.userService.listUsers();
    }

    @GetMapping("/games")
    public List<Game> listAllGames() {
        return this.gameService.listGames();
    }

    @GetMapping("/purchases")
    public List<Purchase> listAllPurchases() {
        return this.purchaseService.listPurchases();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        try {
            User user = this.userService.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Integer id) {
        try {
            Game game = this.gameService.getGame(id);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/purchases/{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable Integer id) {
        try {
            Purchase purchase = this.purchaseService.getPurchase(id);
            return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/games")
    public void createUser(@RequestBody Game game) {
        this.gameService.saveGame(game);
    }


    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        this.userService.saveUser(user);
    }

    @PostMapping("/purchases")
    public void createPurchase(@RequestBody Purchase purchase) {
        this.purchaseService.savePurchase(purchase);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            User theUser = this.userService.getUser(id);
            theUser.setName(user.getName());
            theUser.setEmail(user.getEmail());
            theUser.setBalance(user.getBalance());

            this.userService.saveUser(theUser);

            return new ResponseEntity<User>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/games/{id}")
    public ResponseEntity<?> updateGame(@RequestBody Game game, @PathVariable Integer id) {
        try {
            Game myGame = this.gameService.getGame(id);
            myGame.setName(game.getName());
            myGame.setPrice(game.getPrice());
            this.gameService.saveGame(myGame);
            return new ResponseEntity<Game>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/purchases/{id}")
    public ResponseEntity<?> updatePurchase(@RequestBody Purchase purchase, @PathVariable Integer id) {
        try {
            Purchase newPurchase = this.purchaseService.getPurchase(id);
            newPurchase.setUser(purchase.getUser());
            newPurchase.setGame(purchase.getGame());
            this.purchaseService.savePurchase(newPurchase);

            return new ResponseEntity<Purchase>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        try {
            this.userService.deleteUser(id);
            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Integer id) {
        try {
            this.gameService.deleteGame(id);
            return new ResponseEntity<Game>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/purchases/{id}")
    public ResponseEntity<?> deletePurchase(@PathVariable Integer id)
    {
        try
        {
            this.purchaseService.deletePurchase(id);
            return new ResponseEntity<Purchase>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
        }
    }
}
