package models;

import java.util.ArrayList;
import java.util.List;

/** class Basket receives a list of the order through the constructor. It can remove, add dish to order list and count price of order  **/

public class Basket {

  private List<Dish> orderList  = new ArrayList<>();

   public Basket(List<Dish> orderList){
        this.orderList = orderList;
    }

    /**method add product to order list**/

    public List<Dish> addProductToBasket(Dish dish) throws NullPointerException {
        orderList.add (dish);
        return orderList;
    }

    /**method remove product from order list**/

    public List<Dish> removeProductFromBasket (Dish dish) throws NullPointerException {
        int id = dish.getId ();
        for (int i = 0; i < orderList.size (); i++) {
            Dish model = orderList.get (i);
            int tempId = model.getId ();
            if (id == tempId) {
                orderList.remove (i);
            }
        }return orderList;

    }
  /**method gives price of order**/
    public static int getPriceOfOrder(List<Dish> list) throws NullPointerException{
      int totalPrice = 0;
       for(Dish dish : list){
         totalPrice +=  dish.getPrice();
       }
       return totalPrice;
    }

    public List<Dish> getOrder() throws NullPointerException {
        return orderList;
    }


}
