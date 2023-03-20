package com.kenzie.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

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
    void payment_Interface_Exists_Test() {
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
    void payment_Interface_Class_Has_Correct_Methods() {
        try {
            Method confirmPayment = getClassByClassPath(PAYMENT_CLASS_PATH).getMethod("confirmPayment", double.class);

            Method printReceiptent = getClassByClassPath(PAYMENT_CLASS_PATH).getMethod("printReceipt");

            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Payment Interface should have two methods, confirmPayment, and printReceipt.");
        }
    }

    @Order(4)
    @Test
    void cardPayment_Class_Has_Correct_Methods() {
        try {
            Method confirmPayment = getClassByClassPath(CARDPAYMENT_CLASS_PATH).getMethod("confirmPayment", double.class);

            Method printReceiptent = getClassByClassPath(CARDPAYMENT_CLASS_PATH).getMethod("printReceipt");

            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The CardPayment class should have two methods, confirmPayment, and printReceipt.");
        }
    }

    @Order(5)
    @Test
    void cardPayment_Class_Extends_Abstract_PaymentInterface_Test() {
        assertTrue(doesChildClassImplementInterface(getClassByClassPath(CARDPAYMENT_CLASS_PATH), getClassByClassPath(PAYMENT_CLASS_PATH)), "The CardPayment class does not extend the parent class Payment.");
    }

    @Order(6)
    @Test
    void customer_Interface_Exists_Test() {
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
    void customer_Interface_Class_Has_Correct_Methods() {
        try {
            Method createProfile = getClassByClassPath(CUSTOMER_CLASS_PATH).getMethod("createProfile", String.class);

            Method updateProfile = getClassByClassPath(CUSTOMER_CLASS_PATH).getMethod("updateProfile", String.class);

            Method confirmPayment = getClassByClassPath(CUSTOMER_CLASS_PATH).getMethod("login", String.class, String.class);

            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Customer interface class should have three methods, createProfile, updateProfile, and login.");
        }
    }

    @Order(9)
    @Test
    void onlineCutomer_Class_Has_Correct_Methods() {
        try {
            Method createProfile = getClassByClassPath(ONLINECUSTOMER_CLASS_PATH).getMethod("createProfile", String.class);

            Method updateProfile = getClassByClassPath(ONLINECUSTOMER_CLASS_PATH).getMethod("updateProfile", String.class);

            Method confirmPayment = getClassByClassPath(ONLINECUSTOMER_CLASS_PATH).getMethod("login", String.class, String.class);

            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The OnlineCustomer Class should have three methods, createProfile, updateProfile, and login");
        }
    }

    @Order(10)
    @Test
    void onlineCustomer_Class_Implements_Interface_Customer_Test() {
        assertTrue(doesChildClassImplementInterface(getClassByClassPath(ONLINECUSTOMER_CLASS_PATH), getClassByClassPath(CUSTOMER_CLASS_PATH)), "The OnlineCustomer class does not implement the Customer interface.");
    }


    @Order(11)
    @Test
    void menuItem_AbstractClass_Exists_Test() {
        assertNotNull(getClassByClassPath(MENUITEM_CLASS_PATH), "The MenuItem Abstract class should exist");
    }

    @Order(12)
    @Test
    void menuItemClass_isMarked_asAbstractClass() throws Exception {
        Class<?> myClass = getClassByClassPath(MENUITEM_CLASS_PATH);
        assertTrue(Modifier.isAbstract(myClass.getModifiers()), "The MenuItem Abstract class should be marked and created as an Abstract class");
    }

    @Test
    void menuItem_Class_Has_Correct_Methods() {
        try {
            Method getPrice = getClassByClassPath(MENUITEM_CLASS_PATH).getMethod("getPrice");

            Method setPrice = getClassByClassPath(MENUITEM_CLASS_PATH).getMethod("setPrice", double.class);

            Method confirmPayment = getClassByClassPath(MENUITEM_CLASS_PATH).getMethod("removeItem", int.class);
            assertTrue(Modifier.isAbstract(confirmPayment.getModifiers()), "The removeItem() method should be declared abstract");

            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The FoodItem Class should inherit getPrice and setPrice, and override removeItem.");
        }
    }

    @Order(13)
    @Test
    void foodItem_Class_Has_Correct_Methods() {
        try {
            Method getPrice = getClassByClassPath(FOODITEM_CLASS_PATH).getMethod("getPrice");

            Method setPrice = getClassByClassPath(FOODITEM_CLASS_PATH).getMethod("setPrice", double.class);

            Method confirmPayment = getClassByClassPath(FOODITEM_CLASS_PATH).getMethod("removeItem", int.class);


            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The FoodItem Class should inherit getPrice and setPrice, and override removeItem.");
        }
    }

    @Order(14)
    @Test
    void foodItem_Class_HasNo_PropertiesOutsideOfTheParentClass() {
        String EXPECTED_MODIFIER = "PRIVATE";
        String fieldNameToFind = "itemID";
        String fieldType = "int";

        Object [] CLASS_CONSTRUCTOR_VALUES = {100, "Item Name"};

        Class<?> [] CLASS_CONSTRUCTOR_TYPES = {int.class, String.class};


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(FOODITEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the FoodItem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            assertTrue(true);
        }

        EXPECTED_MODIFIER = "PRIVATE";
        fieldNameToFind = "name";
        fieldType = "String";



        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(FOODITEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the FoodItem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            assertTrue(true);
        }
        EXPECTED_MODIFIER = "PRIVATE";
        fieldNameToFind = "price";
        fieldType = "double";

        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(FOODITEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the FoodItem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }

    @Order(17)
    @Test
    void foodItemClass_Extends_Abstract_MenuItem_AbstractClass_Test() {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(FOODITEM_CLASS_PATH), getClassByClassPath(MENUITEM_CLASS_PATH)), "The FoodItem class does not extend the parent class MenuItem.");
    }

    @Order(18)
    @Test
    void orderClass_Exists_Test() {
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
    void orderClass_Has_Correct_Methods() {
        try {
            Method getTotal = getClassByClassPath(ORDER_CLASS_PATH).getMethod("getTotal");
            assertTrue(!Modifier.isAbstract(getTotal.getModifiers()), "The Order class should have a concrete method getTotal()");


        }
        catch(Exception e) {
            assertTrue(false, "The Order class should have a concrete method getTotal()");
        }

        try {

            Method addItem = getClassByClassPath(ORDER_CLASS_PATH).getMethod("addItem", int.class);
            assertTrue(Modifier.isAbstract(addItem.getModifiers()), "The Order class should have an abstract method addItem()");

        }
        catch(Exception e) {
            assertTrue(false, "The Order class should have an abstract method addItem()");
        }

        try {
            Method removeItem = getClassByClassPath(ORDER_CLASS_PATH).getMethod("removeItem", int.class);
            assertTrue(Modifier.isAbstract(removeItem.getModifiers()), "The Order class should have an abstract method removeItem()");


            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Order class should have an abstract method removeItem()");
        }
    }

    @Order(21)
    @Test
    void foodOrder_Class_Has_Correct_Methods() {
        try {
            Method getTotal = getClassByClassPath(FOODORDER_CLASS_PATH).getMethod("getTotal");

            Method addItem = getClassByClassPath(FOODORDER_CLASS_PATH).getMethod("addItem",  int.class);

            Method removeItem = getClassByClassPath(FOODORDER_CLASS_PATH).getMethod("removeItem", int.class);


            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The FoodOrder class should inherit getTotal and override addItem and removeItem");
        }
    }

    @Order(22)
    @Test
    void foodOrder_Class_HasNo_PropertiesOutsideOfTheParentClass() {
        String EXPECTED_MODIFIER = "public";
        String fieldNameToFind = "items";
        String fieldType = "MenuItem Array";



        Object[] CLASS_CONSTRUCTOR_VALUES = {null, 100.00, "Complete Status"};

        Class<?>[] CLASS_CONSTRUCTOR_TYPES = {Arrays.class, double.class, String.class};


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(FOODITEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the FoodOrder class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            // assertTrue(true);
        }
        EXPECTED_MODIFIER = "public";
        fieldNameToFind = "total";
        fieldType = "double";


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(FOODITEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the FoodOrder class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            //assertTrue(true);
        }
        EXPECTED_MODIFIER = "public";
        fieldNameToFind = "status";
        fieldType = "String";


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(FOODITEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(FOODITEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the FoodOrder class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }

    @Order(25)
    @Test
    void foodOrderClass_Extends_Abstract_OrderClass_Test() {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(FOODORDER_CLASS_PATH), getClassByClassPath(ORDER_CLASS_PATH)), "The FoodOrder class does not extend the parent class Order.");
    }

    @Order(26)
    @Test
    void orderSystem_AbstractClass_Exists_Test() {
        assertNotNull(getClassByClassPath(ORDERSYSTEM_CLASS_PATH), "The abstract OrderSystem class should exist");
    }

    @Order(27)
    @Test
    void orderSystemClass_isMarked_asAbstractClass() throws Exception {
        Class<?> myClass = getClassByClassPath(ORDERSYSTEM_CLASS_PATH);
        assertTrue(Modifier.isAbstract(myClass.getModifiers()),"The OrderSystem class should be marked and created as an abstract class");
    }


    @Test
    void orderSystem_Class_Has_Correct_Methods() {

        try {
            Method selectMenu = getClassByClassPath(ORDERSYSTEM_CLASS_PATH).getMethod("selectMenu", String.class);
            assertTrue(Modifier.isAbstract(selectMenu.getModifiers()), "The Order System class should have an abstract method selectMenu()");


            //assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Order System class should have an abstract method selectMenu().");
        }

        try {
            Method makePayment = getClassByClassPath(ORDERSYSTEM_CLASS_PATH).getMethod("makePayment", getClassByClassPath(ORDER_CLASS_PATH));
            assertTrue(Modifier.isAbstract(makePayment.getModifiers()), "The Order System class should have an abstract method makePayment()");


            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Order System class should have an abstract method makePayment()");
        }
    }


    @Order(28)
    @Test
    void onlineOrderSystem_Class_HasNo_PropertiesOutsideOfTheParentClass() {
        String EXPECTED_MODIFIER = "public";
        String fieldNameToFind = "menuList";
        String fieldType = "Menu Array";

        Object[] CLASS_CONSTRUCTOR_VALUES = {null, "Visa", null, null};

        Class<?>[] CLASS_CONSTRUCTOR_TYPES = {Arrays.class, String.class, getClassByClassPath(FOODORDER_CLASS_PATH), getClassByClassPath(ONLINECUSTOMER_CLASS_PATH)};


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the OnlineOrderSystem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            // assertTrue(true);
        }
        EXPECTED_MODIFIER = "public";
        fieldNameToFind = "paymentOption";
        fieldType = "String";


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the OnlineOrderSystem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            //assertTrue(true);
        }
        EXPECTED_MODIFIER = "public";
        fieldNameToFind = "currentOrder";
        fieldType = "Order";


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the OnlineOrderSystem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            // assertTrue(true);
        }
        EXPECTED_MODIFIER = "public";
        fieldNameToFind = "currentCustomer";
        fieldType = "Customer";



        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the OnlineOrderSystem class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }

    @Order(32)
    @Test
    void onlineOrderSystemClass_Extends_Abstract_OrderSystemClass_Test() {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(ONLINEORDERSYSTEM_CLASS_PATH), getClassByClassPath(ORDERSYSTEM_CLASS_PATH)), "The OnlineOrderSystem class does not extend the parent class OrderSystem.");
    }

    @Order(33)
    @Test
    void menuClass_Exists_Test() {
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
    void restaurantMenu_Class_HasNo_PropertiesOutsideOfTheParentClass() {
        String EXPECTED_MODIFIER = "public";
        String fieldNameToFind = "items";
        String fieldType = "ArrayList";

        Object[] CLASS_CONSTRUCTOR_VALUES = {"Menu Name", null};

        Class<?>[] CLASS_CONSTRUCTOR_TYPES = {String.class, Arrays.class};


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(RESTAURANTMENU_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(RESTAURANTMENU_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the RestaurantMenu class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            //  assertTrue(true);
        }
        EXPECTED_MODIFIER = "public";
        fieldNameToFind = "name";
        fieldType = "String";


        try {
            getFieldValueInClassUsingReflection(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, getClassByClassPath(RESTAURANTMENU_CLASS_PATH));
            assertTrue(isCorrectModifierUsed(fieldNameToFind, CLASS_CONSTRUCTOR_VALUES, CLASS_CONSTRUCTOR_TYPES, EXPECTED_MODIFIER, getClassByClassPath(RESTAURANTMENU_CLASS_PATH)));
            assertTrue(false, "Double check that you DO NOT have a field called: "+ fieldNameToFind + " of type " + fieldType + " in the RestaurantMenu class that has the " + EXPECTED_MODIFIER + " Modifier. These properties should live in the parent class only.");
        }
        catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void menu_Class_Has_Correct_Methods() {
        try {
            Method displayMenu = getClassByClassPath(MENU_CLASS_PATH).getMethod("displayMenu");
            assertTrue(Modifier.isAbstract(displayMenu.getModifiers()), "The Menu class should have an abstract method displayMenu()");

            // assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Menu Class should have an abstract method displayMenu.");
        }

        try {
            Method addItem = getClassByClassPath(MENU_CLASS_PATH).getMethod("addItem", int.class);
            assertTrue(Modifier.isAbstract(addItem.getModifiers()), "The Menu class should have an abstract method addItem()");


            //assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Menu class should have an abstract method addItem().");
        }

        try {
            Method removeItem = getClassByClassPath(MENU_CLASS_PATH).getMethod("removeItem", int.class);
            assertTrue(Modifier.isAbstract(removeItem.getModifiers()), "The Menu class should have an abstract method removeItem()");


            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The Menu class should have an abstract method removeItem()");
        }
    }


    @Order(37)
    @Test
    void restaurantMenu_Class_Has_Correct_Methods() {
        try {
            Method displayMenu = getClassByClassPath(RESTAURANTMENU_CLASS_PATH).getMethod("displayMenu");

            Method addItem = getClassByClassPath(RESTAURANTMENU_CLASS_PATH).getMethod("addItem", int.class);

            Method removeItem = getClassByClassPath(RESTAURANTMENU_CLASS_PATH).getMethod("removeItem", int.class);


            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false, "The RestaurantMenu Class should have 3 methods, displayMenu, addItem, and removeItem.");
        }
    }

    @Order(38)
    @Test
    void restaurantMenuClass_Extends_Abstract_MenuClass_Test() {
        assertTrue(doesChildClassExtendParentClass(getClassByClassPath(RESTAURANTMENU_CLASS_PATH), getClassByClassPath(MENU_CLASS_PATH)), "The RestaurantMenu class does not extend the parent class Menu.");
    }


    private Class<?> getClassByClassPath(String classNameToFind) throws NoSuchElementException {
        try {
            Class<?> classRetrieved = Class.forName(classNameToFind);
            return classRetrieved;
        }
        catch(Exception e){
            throw new NoSuchElementException("The class " + classNameToFind + " has not been created yet. Please ensure you have created the appropriate classes per the assingment instructions before continuing.");
        }
    }
    private boolean doesChildClassExtendParentClass(Class<?> childClass, Class<?> parentClassToCheck) throws NoSuchElementException {
        try {
            if(childClass == null || parentClassToCheck == null) {
                throw new Exception("You need to provide a parent and child class to check if a child class extends a given parent class.");
            }

            if(childClass.getSuperclass() == parentClassToCheck) {
                return true;
            }
        }
        catch(Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

        return false;
    }

    private boolean doesChildClassImplementInterface(Class<?> classThatShouldHaveInterface, Class<?> interfaceClass) throws NoSuchElementException {
        try {
            if(classThatShouldHaveInterface == null || interfaceClass == null) {
                throw new Exception("You need to provide a a valid Interface and Class Name to check.");
            }
            else {
                Class x = classThatShouldHaveInterface; //
                Class[] interfaces = x.getInterfaces();

                for (Class i : interfaces) {
                    if (i.toString().equals(interfaceClass.toString())) {
                        return true;
                    }
                }
            }
        }
        catch(Exception e){
            throw new NoSuchElementException(e.getMessage());
        }

        return false;
    }

    private <T> T getClassToConstruct(Object[] params, Class<?>[] paramTypes, Class<?> classToConstruct) throws Exception {

        if(params == null || paramTypes == null || classToConstruct == null) {
            throw new Exception("params, paramTypes, and classToConstruct parameters must be provided to use this method.");
        }
        else {
            Constructor constructor = classToConstruct.getConstructor(paramTypes);
            return (T) constructor.newInstance(params);
        }
    }

    private String getFieldValueInClassUsingReflection(String variableName, Object[] params, Class<?>[] paramTypes, Class<?> classToConstruct) {
        try {
            Class<?> myClass = getClassToConstruct(params, paramTypes, classToConstruct);

            Field field = myClass.getSuperclass().getDeclaredField(variableName);
            Object fieldType = field.getType();

            field.setAccessible(true);

            if (field.get(myClass) == null){
                return "";
            }

            return field.get(myClass).toString();

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isCorrectModifierUsed(String variableName, Object[] params, Class<?> [] paramTypes, String expectedModifier, Class<?> classToConstruct) {
        try {
            if(paramTypes == null || expectedModifier == null || expectedModifier.isEmpty() || expectedModifier.isBlank() ) {
                throw new Exception("paramTypes and expectedModifier parameters must be provided and must be valid.");
            }
            Class<?> myClass = getClassToConstruct(params, paramTypes, classToConstruct);

            Field field = myClass.getDeclaredField(variableName);
            Object fieldType = field.getType();

            int modifiers = field.getModifiers();

            String expectedModifierToLower = expectedModifier.toLowerCase();

            if(Modifier.isProtected(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("protected")) {
                    return true;
                }
            }
            else if(Modifier.isPrivate(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("private")) {
                    return true;
                }
            }
            else if(Modifier.isPublic(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("public")) {
                    return true;
                }
            }
            else if(Modifier.isAbstract(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("abstract")) {
                    return true;
                }
            }
            else if(Modifier.isFinal(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("final")) {
                    return true;
                }
            }
            else if(Modifier.isInterface(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("interface")) {
                    return true;
                }
            }
            else if(Modifier.isStatic(modifiers)) {
                if(expectedModifier.toLowerCase().equalsIgnoreCase("static")) {
                    return true;
                }
            }

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}