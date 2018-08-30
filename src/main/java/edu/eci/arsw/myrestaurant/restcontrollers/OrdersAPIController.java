/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.arsw.myrestaurant.restcontrollers;

import edu.eci.arsw.myrestaurant.model.Order;
import edu.eci.arsw.myrestaurant.model.ProductType;
import edu.eci.arsw.myrestaurant.model.RestaurantProduct;
import edu.eci.arsw.myrestaurant.services.OrderServicesException;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServices;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServicesStub;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */

@RestController
@RequestMapping(value = "/orders")
public class OrdersAPIController {
    
    @Autowired
    RestaurantOrderServices ros;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetOrderHandler() {
        try {
            return new ResponseEntity<>(ros.getOrders(), HttpStatus.ACCEPTED);
        } catch (OrderServicesException ex) {
            Logger.getLogger(OrderServicesException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping("/{idtable}")
    public ResponseEntity<?> GetOrderHandler(@PathVariable int idtable) {
        Order order = ros.getTableOrder(idtable);
        HttpStatus status = HttpStatus.ACCEPTED;
        if(order == null){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(order, status);
        
    }
    
    @RequestMapping(method = RequestMethod.POST)	
	public ResponseEntity<?> manejadorPostRecursoXX(@RequestBody Order order){
		try {
			ros.addNewOrderToTable(order);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (OrderServicesException ex) {
			Logger.getLogger(OrderServicesException.class.getName()).log(Level.SEVERE, null, ex);
			return new ResponseEntity<>("Error bla bla bla",HttpStatus.FORBIDDEN);            
		}        
	
	}
}

