package models;

import java.util.ArrayList;
import java.util.List;

/** class Basket receives a list of the order through the constructor. It can remove, add dish to order list and count price of order  **/

public class Basket {

  private static List<Dish> orderList  = new ArrayList<>();

   public Basket(List<Dish> orderList){
        this.orderList = orderList;
    }

   public Basket(){}

    /**method add product to order list**/

    public void addProductToBasket(Dish dish)  {
        orderList.add (dish);
    }

    /**method remove product from order list**/

    public void removeProductFromBasket (Dish dish) {
        int id = dish.getId ();
        for (int i = 0; i < orderList.size (); i++) {
            Dish model = orderList.get (i);
            int tempId = model.getId ();
            if (id == tempId) {
                orderList.remove (i);
            }
        }
    }
  /**method gives price of order**/
    public  int getPriceOfOrder() {
      int totalPrice = 0;
       for(Dish dish : orderList){
         totalPrice +=  dish.getPrice();
       }
       return totalPrice;
    }

    public List<Dish> getOrder() {
        return orderList;
    }
}
