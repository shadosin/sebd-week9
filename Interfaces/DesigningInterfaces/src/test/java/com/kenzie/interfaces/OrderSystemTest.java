package com.kenzie.interfaces;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderSystemTest {

    static final String PAYMENT_CLASS_PATH = "com.kenzie.interfaces.Payment";
    static final String CUSTOMER_CLASS_PATH = "com.kenzie.interfaces.Customer";
    static final String MENUITEM_CLASS_PATH = "com.kenzie.interfaces.MenuItem";
    static final String ORDER_CLASS_PATH = "com.kenzie.interfaces.Order";
    static final String ORDERSYSTEM_CLASS_PATH = "com.kenzie.interfaces.OrderSystem";
    static final String MENU_CLASS_PATH = "com.kenzie.interfaces.Menu";
    static final String CARDPAYMENT_CLASS_PATH = "com.kenzie.interfaces.CardPayment";
    static final String FOODITEM_CLASS_PATH = "com.kenzie.interfaces.FoodItem";
    static final String FOODORDER_CLASS_PATH = "com.kenzie.interfaces.FoodOrder";
    static final String ONLINECUSTOMER_CLASS_PATH = "com.kenzie.interfaces.OnlineCustomer";
    static final String ONLINEORDERSYSTEM_CLASS_PATH = "com.kenzie.interfaces.OnlineOrderSystem";
    static final String RESTAURANTMENU_CLASS_PATH = "com.kenzie.interfaces.RestaurantMenu";


    @Order(1)
    @Test
    void payment_Interface_Exists_Test() throws Exception {
        assertNotNull(getClassByClassPath(PAYMENT_CLASS_PATH), "The Payment Abstract Class should exist.");
    }

    @Order(2)
    @Test
    void paymentClass_isMarked_asInterface() throws Exception {
        Class<?> myClass = getClassByClassPath(PAYMENT_CLASS_PATH);
        assertTrue(Modifier.isInterface(myClass.getModifiers()), "The Payment class should be marked and created as an interface.");
    }

    @Order(3)
    @Test
    void payment_Interface_Class_Has_Correct_Methods() throws Exception {
        Method confirmPayment = getClassByClassPath(PAYMENT_CLASS_PATH).getMethod("confirmPayment", double.class);
        Method printReceipt = getClassByClassPath(PAYMENT_CLASS_PATH).getMethod("printReceipt");
    }

    @Order(4)
    @Test
    void cardPayment_Class_Has_Correct_Methods() throws Exception {
        Method confirmPayment = getClassByClassPath(CARDPAYMENT_CLASS_PATH).getMethod("confirmPayment", double.class);
        Method printReceipt = getClassByClassPath(CARDPAYMENT_CLASS_PATH).getMethod("printReceipt");
    }

    @Order(5)
    @Test
    void cardPayment_Class_Extends_Abstract_PaymentInterface_Test() throws Exception {
        assertTrue(doesChildClassImplementInterface(getClassByClassPath(CARDPAYMENT_CLASS_PATH), getClassByClassPath(PAYMENT_CLASS_PATH)), "The CardPayment class does not extend the parent class Payment.");
    }

    @Order(6)
    @Test
    void customer_Interface_Exists_Test() throws Exception {
        assertNotNull(getClassByClassPath(CUSTOMER_CLASS_PATH), "The Customer interface should exist.");
    }

    @Order(7)
    @Test
    void customerClass_isMarked_asInterface() throws Exception {
        Class<?> myClass = getClassByClassPath(CUSTOMER_CLASS_PATH);
        assertTrue(Modifier.isInterface(myClass.getModifiers()), "The Customer Class should be marked and created as an interface");
    }

    @Order(8)
    @Test
    void customer_Interface_Class_Has_Correct_Methods() throws Exception {
        Method createProfile = getClassByClassPath(CUSTOMER_CLASS_PATH).getMethod("createProfile", String.class);
        Method updateProfile = getClassByClassPath(CUSTOMER_CLASS_PATH).getMethod("updateProfile", String.class);
        Method confirmPayment = getClassByClassPath(CUSTOMER_CLASS_PATH).getMethod("login", String.class, String.class);
    }

    @Order(9)
    @Test
    void onlineCutomer_Class_Has_Correct_Methods() throws Exception {
        Method createProfile = getClassByClassPath(ONLINECUSTOMER_CLASS_PATH).getMethod("createProfile", String.class);
        Method updateProfile = getClassByClassPath(ONLINECUSTOMER_CLASS_PATH).getMethod("updateProfile", String.class);
        Method confirmPayment = getClassByClassPath(ONLINECUSTOMER_CLASS_PATH).getMethod("login", String.class, String.class);
    }

    @Order(10)
    @Test
    void onlineCustomer_Class_Implements_Interface_Customer_Test() throws Exception {
        assertTrue(doesChildClassImplementInterface(getClassByClassPath(ONLINECUSTOMER_CLASS_PATH), getClassByClassPath(CUSTOMER_CLASS_PATH)), "The OnlineCustomer class does not implement the Customer interface.");
    }


    @Order(11)
    @Test
    void menuItem_AbstractClass_Exists_Test() throws Exception {
        assertNotNull(getClassByClassPath(MENUITEM_CLASS_PATH), "The MenuItem Abstract class should exist");
    }

    @Order(12)
    @Test
    void menuItemClass_isMarked_asAbstractClass() throws Exception {
        Class<?> myClass = getClassByClassPath(MENUITEM_CLASS_PATH);
        assertTrue(Modifier.isAbstract(myClass.getModifiers()), "The MenuItem Abstract class should be marked and created as an Abstract class");
    }

    @Test
    void menuItem_Class_Has_Correct_Methods() throws Exception {
        Method getPrice = getClassByClassPath(MENUITEM_CLASS_PATH).getMethod("getPrice");
        Method setPrice = getClassByClassPath(MENUITEM_CLASS_PATH).getMethod("setPrice", double.class);

        Method confirmPayment = getClassByClassPath(MENUITEM_CLASS_PATH).getMethod("removeItem", int.class);
        assertTrue(Modifier.isAbstract(confirmPayment.getModifiers()), "The removeItem() method should be declared abstract");
    }

    @Order(13)
    @Test
    void foodItem_Class_Has_Correct_Methods() throws Exception {
        Method getPrice = getClassByClassPath(FOODITEM_CLASS_PATH).getMethod("getPrice");
        Method setPrice = getClassByClassPath(FOODITEM_CLASS_PATH).getMethod("setPrice", double.class);
        Method confirmPayment = getClassByClassPath(FOODITEM_CLASS_PATH).getMethod("removeItem", int.class);
    }

    @Order(14)
    @Test
    void foodItem_Class_HasNo_PropertiesOutsideOfTheParentClass() throws Exception {

        Object[] CLASS_CONSTRUCTOR_VALUES = new Object[]{1234, "Item Name", 100};
        Class[] CLASS_CONSTRUCTOR_TYPES = new Class[]{int.class, String.class, double.class};
        String[] fieldsToCheck = {"price", "name", "itemID"};

        for(String field: fieldsToCheck) {
            String declaration = getFieldValueInClassUsingReflection(
                    field,
                    CLASS_CONSTRUCTOR_VALUES,
                    CLASS_CONSTRUCTOR_TYPES,
                    getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(declaration.contains("private"), "Make sure class variable is private");
        }
    }

    @Order(17)
    @Test
    void foodItemClass_Extends_Abstract_MenuItem_AbstractClass_Test() throws Exception {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(FOODITEM_CLASS_PATH), getClassByClassPath(MENUITEM_CLASS_PATH)), "The FoodItem class does not extend the parent class MenuItem.");
    }

    @Order(18)
    @Test
    void orderClass_Exists_Test() throws Exception {
        assertNotNull(getClassByClassPath(ORDER_CLASS_PATH), "The Order Abstract class should exist");
    }

    @Order(19)
    @Test
    void orderClass_isMarked_asAbstractClass() throws Exception {
        Class<?> myClass = getClassByClassPath(ORDER_CLASS_PATH);
        assertTrue(Modifier.isAbstract(myClass.getModifiers()), "The Order class should be marked and created as an Abstract class");
    }

    @Order(20)
    @Test
    void orderClass_Has_Correct_Methods() throws Exception {
        Method getTotal = getClassByClassPath(ORDER_CLASS_PATH).getMethod("getTotal");
        assertTrue(!Modifier.isAbstract(getTotal.getModifiers()), "The Order class should have a concrete method getTotal()");

        Method addItem = getClassByClassPath(ORDER_CLASS_PATH).getMethod("addItem", int.class);
        assertTrue(Modifier.isAbstract(addItem.getModifiers()), "The Order class should have an abstract method addItem()");

        Method removeItem = getClassByClassPath(ORDER_CLASS_PATH).getMethod("removeItem", int.class);
        assertTrue(Modifier.isAbstract(removeItem.getModifiers()), "The Order class should have an abstract method removeItem()");
    }

    @Order(21)
    @Test
    void foodOrder_Class_Has_Correct_Methods() throws Exception {
        Method getTotal = getClassByClassPath(FOODORDER_CLASS_PATH).getMethod("getTotal");
        Method addItem = getClassByClassPath(FOODORDER_CLASS_PATH).getMethod("addItem", int.class);
        Method removeItem = getClassByClassPath(FOODORDER_CLASS_PATH).getMethod("removeItem", int.class);
    }


    @Order(25)
    @Test
    void foodOrderClass_Extends_Abstract_OrderClass_Test() throws Exception {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(FOODORDER_CLASS_PATH), getClassByClassPath(ORDER_CLASS_PATH)), "The FoodOrder class does not extend the parent class Order.");
    }

    @Order(26)
    @Test
    void orderSystem_AbstractClass_Exists_Test() throws Exception {
        assertNotNull(getClassByClassPath(ORDERSYSTEM_CLASS_PATH), "The abstract OrderSystem class should exist");
    }

    @Order(27)
    @Test
    void orderSystemClass_isMarked_asAbstractClass() throws Exception {
        Class<?> myClass = getClassByClassPath(ORDERSYSTEM_CLASS_PATH);
        assertTrue(Modifier.isAbstract(myClass.getModifiers()), "The OrderSystem class should be marked and created as an abstract class");
    }


    @Test
    void orderSystem_Class_Has_Correct_Methods() throws Exception {
        Method selectMenu = getClassByClassPath(ORDERSYSTEM_CLASS_PATH).getMethod("selectMenu", String.class);
        assertTrue(Modifier.isAbstract(selectMenu.getModifiers()), "The Order System class should have an abstract method selectMenu()");

        Method makePayment = getClassByClassPath(ORDERSYSTEM_CLASS_PATH).getMethod("makePayment", getClassByClassPath(ORDER_CLASS_PATH));
        assertTrue(Modifier.isAbstract(makePayment.getModifiers()), "The Order System class should have an abstract method makePayment()");
    }


    @Order(28)
    @Test
    void onlineOrderSystem_Class_HasNo_PropertiesOutsideOfTheParentClass() throws Exception {

        Object[] CLASS_CONSTRUCTOR_VALUES = {null, "Visa", null, null};
        Class<?>[] CLASS_CONSTRUCTOR_TYPES = {Arrays.class, String.class, getClassByClassPath(FOODORDER_CLASS_PATH), getClassByClassPath(ONLINECUSTOMER_CLASS_PATH)};

        String[] fieldsToCheck = {"menuList", "paymentOption", "currentOrder", "currentCustomer"};

        for(String field: fieldsToCheck) {
            String declaration = getFieldValueInClassUsingReflection(
                    field,
                    CLASS_CONSTRUCTOR_VALUES,
                    CLASS_CONSTRUCTOR_TYPES,
                    getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH));
            assertTrue(declaration.contains("public"), "Make sure class variable is public");
        }
    }

    @Order(32)
    @Test
    void onlineOrderSystemClass_Extends_Abstract_OrderSystemClass_Test() throws Exception {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH), getClassByClassPath(ORDERSYSTEM_CLASS_PATH)), "The OnlineOrderSystem class does not extend the parent class OrderSystem.");
    }

    @Order(33)
    @Test
    void menuClass_Exists_Test() throws Exception {
        assertNotNull(getClassByClassPath(MENU_CLASS_PATH), "The Menu Abstract class should exist");
    }

    @Order(34)
    @Test
    void menuClass_isMarked_asAbstractClass() throws Exception {
        Class<?> myClass = getClassByClassPath(MENU_CLASS_PATH);
        assertTrue(Modifier.isAbstract(myClass.getModifiers()), "The Menu class should be marked and created as an abstract class");
    }


    @Order(35)
    @Test
    void restaurantMenu_Class_HasNo_PropertiesOutsideOfTheParentClass() throws Exception {
        String[] fieldsToCheck = {"items", "name" };

        Object[] CLASS_CONSTRUCTOR_VALUES = {"Menu Name", null};
        Class<?>[] CLASS_CONSTRUCTOR_TYPES = {String.class, Arrays.class};

        for(String field: fieldsToCheck) {
            String declaration = getFieldValueInClassUsingReflection(
                    field,
                    CLASS_CONSTRUCTOR_VALUES,
                    CLASS_CONSTRUCTOR_TYPES,
                    getClassByClassPath(RESTAURANTMENU_CLASS_PATH));
            assertTrue(declaration.toLowerCase().contains("public"), "Make sure your variable is public");
        }

     }

    @Test
    void menu_Class_Has_Correct_Methods() throws Exception {
        Method displayMenu = getClassByClassPath(MENU_CLASS_PATH).getMethod("displayMenu");
        assertTrue(Modifier.isAbstract(displayMenu.getModifiers()), "The Menu class should have an abstract method displayMenu()");

        Method addItem = getClassByClassPath(MENU_CLASS_PATH).getMethod("addItem", int.class);
        assertTrue(Modifier.isAbstract(addItem.getModifiers()), "The Menu class should have an abstract method addItem()");

        Method removeItem = getClassByClassPath(MENU_CLASS_PATH).getMethod("removeItem", int.class);
        assertTrue(Modifier.isAbstract(removeItem.getModifiers()), "The Menu class should have an abstract method removeItem()");
    }


    @Order(37)
    @Test
    void restaurantMenu_Class_Has_Correct_Methods() throws Exception {
        Method displayMenu = getClassByClassPath(RESTAURANTMENU_CLASS_PATH).getMethod("displayMenu");
        Method addItem = getClassByClassPath(RESTAURANTMENU_CLASS_PATH).getMethod("addItem", int.class);
        Method removeItem = getClassByClassPath(RESTAURANTMENU_CLASS_PATH).getMethod("removeItem", int.class);
    }

    @Order(38)
    @Test
    void restaurantMenuClass_Extends_Abstract_MenuClass_Test() throws Exception {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(RESTAURANTMENU_CLASS_PATH), getClassByClassPath(MENU_CLASS_PATH)), "The RestaurantMenu class does not extend the parent class Menu.");
    }


    private Class<?> getClassByClassPath(String classNameToFind) throws NoSuchElementException, ClassNotFoundException {
        Class<?> classRetrieved = Class.forName(classNameToFind);
        return classRetrieved;
    }

    private boolean doesChildClassExtendParentClass(Class<?> childClass, Class<?> parentClassToCheck) throws Exception {
        if (childClass == null || parentClassToCheck == null) {
            throw new Exception("You need to provide a parent and child class to check if a child class extends a given parent class.");
        }

        if (childClass.getSuperclass() == parentClassToCheck) {
            return true;
        }

        return false;
    }

    private boolean doesChildClassImplementInterface(Class<?> classThatShouldHaveInterface, Class<?> interfaceClass) throws Exception {
        if (classThatShouldHaveInterface == null || interfaceClass == null) {
            throw new Exception("You need to provide a a valid Interface and Class Name to check.");
        } else {
            Class x = classThatShouldHaveInterface; //
            Class[] interfaces = x.getInterfaces();

            for (Class i : interfaces) {
                if (i.toString().equals(interfaceClass.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?>[] paramTypes, Class<?> classToConstruct) throws Exception {
        Field field = classToConstruct.getSuperclass().getDeclaredField(variableName);
        field.setAccessible(true);
        return field.toString();
    }
}