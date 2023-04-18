//%% NEW FILE Order BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 26 "model.ump"
// line 312 "model.ump"
public class Order extends Payment
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Order Attributes
    private String orderId;
    private List orderItems;
    private Payment payment;
    private String orderStatus;

    //Order Associations
    private WebhookEvent webhookEvent;
    private Customer customer;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Order(String aId, Customer aCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint, double aAmount, String aCurrency, paymentStatus aStatus, PaymentMethod aPaymentMethod, String aOrderId, List aOrderItems, Payment aPayment, String aOrderStatus, WebhookEvent aWebhookEvent, Customer aCustomer)
    {
        super(aId, aCustomer, aLineItems, aPaymentMethod, aPaymentStatus, aPaymentEndpoint, aAmount, aCurrency, aStatus, aPaymentMethod);
        orderId = aOrderId;
        orderItems = aOrderItems;
        payment = aPayment;
        orderStatus = aOrderStatus;
        if (aWebhookEvent == null || aWebhookEvent.getOrder() != null)
        {
            throw new RuntimeException("Unable to create Order due to aWebhookEvent. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        webhookEvent = aWebhookEvent;
        if (aCustomer == null || aCustomer.getOrder() != null)
        {
            throw new RuntimeException("Unable to create Order due to aCustomer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        customer = aCustomer;
    }

    public Order(String aId, String aIdForCustomer, String aEmailForCustomer, Address aShippingaddressForCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint, double aAmount, String aCurrency, paymentStatus aStatus, PaymentMethod aPaymentMethod, String aOrderId, List aOrderItems, Payment aPayment, String aOrderStatus, String aEventTypeForWebhookEvent, Map aEventDataForWebhookEvent, FailedTransaction aFailedTransactionForWebhookEvent, String aIdForCustomer, String aEmailForCustomer, Address aShippingaddressForCustomer)
    {
        super(aId, aCustomer, aLineItems, aPaymentMethod, aPaymentStatus, aPaymentEndpoint, aAmount, aCurrency, aStatus, aPaymentMethod);
        orderId = aOrderId;
        orderItems = aOrderItems;
        payment = aPayment;
        orderStatus = aOrderStatus;
        webhookEvent = new WebhookEvent(aEventTypeForWebhookEvent, aEventDataForWebhookEvent, this, aFailedTransactionForWebhookEvent);
        customer = new Customer(aIdForCustomer, aEmailForCustomer, aShippingaddressForCustomer, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setOrderId(String aOrderId)
    {
        boolean wasSet = false;
        orderId = aOrderId;
        wasSet = true;
        return wasSet;
    }

    public boolean setOrderItems(List aOrderItems)
    {
        boolean wasSet = false;
        orderItems = aOrderItems;
        wasSet = true;
        return wasSet;
    }

    public boolean setPayment(Payment aPayment)
    {
        boolean wasSet = false;
        payment = aPayment;
        wasSet = true;
        return wasSet;
    }

    public boolean setOrderStatus(String aOrderStatus)
    {
        boolean wasSet = false;
        orderStatus = aOrderStatus;
        wasSet = true;
        return wasSet;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public List getOrderItems()
    {
        return orderItems;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }
    /* Code from template association_GetOne */
    public WebhookEvent getWebhookEvent()
    {
        return webhookEvent;
    }
    /* Code from template association_GetOne */
    public Customer getCustomer()
    {
        return customer;
    }

    public void delete()
    {
        WebhookEvent existingWebhookEvent = webhookEvent;
        webhookEvent = null;
        if (existingWebhookEvent != null)
        {
            existingWebhookEvent.delete();
        }
        Customer existingCustomer = customer;
        customer = null;
        if (existingCustomer != null)
        {
            existingCustomer.delete();
        }
        super.delete();
    }

    // line 37 "model.ump"
    public Order fulfillOrder(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "orderId" + ":" + getOrderId()+ "," +
                "orderStatus" + ":" + getOrderStatus()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "orderItems" + "=" + (getOrderItems() != null ? !getOrderItems().equals(this)  ? getOrderItems().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "payment" + "=" + (getPayment() != null ? !getPayment().equals(this)  ? getPayment().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "webhookEvent = "+(getWebhookEvent()!=null?Integer.toHexString(System.identityHashCode(getWebhookEvent())):"null") + System.getProperties().getProperty("line.separator") +
                "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
    }
}



//%% NEW FILE PayPal BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 250 "model.ump"
// line 402 "model.ump"
public class PayPal extends PaymentMethod
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //PayPal Attributes
    private String payPalToken;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public PayPal(String aId, String aName, Payment aPayment, String aPayPalToken)
    {
        super(aId, aName, aPayment);
        payPalToken = aPayPalToken;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setPayPalToken(String aPayPalToken)
    {
        boolean wasSet = false;
        payPalToken = aPayPalToken;
        wasSet = true;
        return wasSet;
    }

    public String getPayPalToken()
    {
        return payPalToken;
    }

    public void delete()
    {
        super.delete();
    }

    // line 256 "model.ump"
    public Payment processPayment(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "payPalToken" + ":" + getPayPalToken()+ "]";
    }
}



//%% NEW FILE CheckoutSession BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 64 "model.ump"
// line 323 "model.ump"
public class CheckoutSession
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //CheckoutSession Attributes
    private String id;
    private Customer customer;
    private List lineItems;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

    //CheckoutSession Associations
    private PaymentEndpoint paymentEndpoint;
    private List<Customer> customers;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public CheckoutSession(String aId, Customer aCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint)
    {
        id = aId;
        customer = aCustomer;
        lineItems = aLineItems;
        paymentMethod = aPaymentMethod;
        paymentStatus = aPaymentStatus;
        if (aPaymentEndpoint == null || aPaymentEndpoint.getCheckoutSession() != null)
        {
            throw new RuntimeException("Unable to create CheckoutSession due to aPaymentEndpoint. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        paymentEndpoint = aPaymentEndpoint;
        customers = new ArrayList<Customer>();
    }

    public CheckoutSession(String aId, Customer aCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, String aUrlForPaymentEndpoint)
    {
        id = aId;
        customer = aCustomer;
        lineItems = aLineItems;
        paymentMethod = aPaymentMethod;
        paymentStatus = aPaymentStatus;
        paymentEndpoint = new PaymentEndpoint(aUrlForPaymentEndpoint, this);
        customers = new ArrayList<Customer>();
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(String aId)
    {
        boolean wasSet = false;
        id = aId;
        wasSet = true;
        return wasSet;
    }

    public boolean setCustomer(Customer aCustomer)
    {
        boolean wasSet = false;
        customer = aCustomer;
        wasSet = true;
        return wasSet;
    }

    public boolean setLineItems(List aLineItems)
    {
        boolean wasSet = false;
        lineItems = aLineItems;
        wasSet = true;
        return wasSet;
    }

    public boolean setPaymentMethod(PaymentMethod aPaymentMethod)
    {
        boolean wasSet = false;
        paymentMethod = aPaymentMethod;
        wasSet = true;
        return wasSet;
    }

    public boolean setPaymentStatus(PaymentStatus aPaymentStatus)
    {
        boolean wasSet = false;
        paymentStatus = aPaymentStatus;
        wasSet = true;
        return wasSet;
    }

    public String getId()
    {
        return id;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public List getLineItems()
    {
        return lineItems;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    public PaymentStatus getPaymentStatus()
    {
        return paymentStatus;
    }
    /* Code from template association_GetOne */
    public PaymentEndpoint getPaymentEndpoint()
    {
        return paymentEndpoint;
    }
    /* Code from template association_GetOne_clear */
    protected void clear_paymentEndpoint()
    {
        paymentEndpoint = null;
    }
    /* Code from template association_GetMany */
    public Customer getCustomer(int index)
    {
        Customer aCustomer = customers.get(index);
        return aCustomer;
    }

    public List<Customer> getCustomers()
    {
        List<Customer> newCustomers = Collections.unmodifiableList(customers);
        return newCustomers;
    }

    public int numberOfCustomers()
    {
        int number = customers.size();
        return number;
    }

    public boolean hasCustomers()
    {
        boolean has = customers.size() > 0;
        return has;
    }

    public int indexOfCustomer(Customer aCustomer)
    {
        int index = customers.indexOf(aCustomer);
        return index;
    }
    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfCustomers()
    {
        return 0;
    }
    /* Code from template association_AddManyToManyMethod */
    public boolean addCustomer(Customer aCustomer)
    {
        boolean wasAdded = false;
        if (customers.contains(aCustomer)) { return false; }
        customers.add(aCustomer);
        if (aCustomer.indexOfCheckoutSession(this) != -1)
        {
            wasAdded = true;
        }
        else
        {
            wasAdded = aCustomer.addCheckoutSession(this);
            if (!wasAdded)
            {
                customers.remove(aCustomer);
            }
        }
        return wasAdded;
    }
    /* Code from template association_RemoveMany */
    public boolean removeCustomer(Customer aCustomer)
    {
        boolean wasRemoved = false;
        if (!customers.contains(aCustomer))
        {
            return wasRemoved;
        }

        int oldIndex = customers.indexOf(aCustomer);
        customers.remove(oldIndex);
        if (aCustomer.indexOfCheckoutSession(this) == -1)
        {
            wasRemoved = true;
        }
        else
        {
            wasRemoved = aCustomer.removeCheckoutSession(this);
            if (!wasRemoved)
            {
                customers.add(oldIndex,aCustomer);
            }
        }
        return wasRemoved;
    }
    /* Code from template association_AddIndexControlFunctions */
    public boolean addCustomerAt(Customer aCustomer, int index)
    {
        boolean wasAdded = false;
        if(addCustomer(aCustomer))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
            customers.remove(aCustomer);
            customers.add(index, aCustomer);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveCustomerAt(Customer aCustomer, int index)
    {
        boolean wasAdded = false;
        if(customers.contains(aCustomer))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
            customers.remove(aCustomer);
            customers.add(index, aCustomer);
            wasAdded = true;
        }
        else
        {
            wasAdded = addCustomerAt(aCustomer, index);
        }
        return wasAdded;
    }

    public void delete()
    {
        PaymentEndpoint existingPaymentEndpoint = paymentEndpoint;
        paymentEndpoint = null;
        if (existingPaymentEndpoint != null)
        {
            existingPaymentEndpoint.delete();
        }
        ArrayList<Customer> copyOfCustomers = new ArrayList<Customer>(customers);
        customers.clear();
        for(Customer aCustomer : copyOfCustomers)
        {
            aCustomer.removeCheckoutSession(this);
        }
    }

    // line 76 "model.ump"
    public Customer create(customer arg0, lineItems arg1){

    }

    // line 79 "model.ump"
    public String getPaymentURL(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "customer" + "=" + (getCustomer() != null ? !getCustomer().equals(this)  ? getCustomer().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "lineItems" + "=" + (getLineItems() != null ? !getLineItems().equals(this)  ? getLineItems().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "paymentMethod" + "=" + (getPaymentMethod() != null ? !getPaymentMethod().equals(this)  ? getPaymentMethod().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "paymentStatus" + "=" + (getPaymentStatus() != null ? !getPaymentStatus().equals(this)  ? getPaymentStatus().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "paymentEndpoint = "+(getPaymentEndpoint()!=null?Integer.toHexString(System.identityHashCode(getPaymentEndpoint())):"null");
    }
    //------------------------
    // DEVELOPER CODE - PROVIDED AS-IS
    //------------------------

    // line 72 "model.ump"
  * --  PaymentMethod ;


}



//%% NEW FILE PaymentPage BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 158 "model.ump"
// line 362 "model.ump"
public class PaymentPage extends CheckoutSession
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //PaymentPage Attributes
    private String url;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public PaymentPage(String aId, Customer aCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint, String aUrl)
    {
        super(aId, aCustomer, aLineItems, aPaymentMethod, aPaymentStatus, aPaymentEndpoint);
        url = aUrl;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setUrl(String aUrl)
    {
        boolean wasSet = false;
        url = aUrl;
        wasSet = true;
        return wasSet;
    }

    public String getUrl()
    {
        return url;
    }

    public void delete()
    {
        super.delete();
    }

    // line 164 "model.ump"
    public void redirectToPaymentPage(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "url" + ":" + getUrl()+ "]";
    }
}



//%% NEW FILE PaymentEndpoint BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 167 "model.ump"
// line 367 "model.ump"
public class PaymentEndpoint
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //PaymentEndpoint Attributes
    private String url;

    //PaymentEndpoint Associations
    private CheckoutSession checkoutSession;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public PaymentEndpoint(String aUrl, CheckoutSession aCheckoutSession)
    {
        url = aUrl;
        if (aCheckoutSession == null || aCheckoutSession.getPaymentEndpoint() != null)
        {
            throw new RuntimeException("Unable to create PaymentEndpoint due to aCheckoutSession. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        checkoutSession = aCheckoutSession;
    }

    public PaymentEndpoint(String aUrl, String aIdForCheckoutSession, Customer aCustomerForCheckoutSession, List aLineItemsForCheckoutSession, PaymentMethod aPaymentMethodForCheckoutSession, PaymentStatus aPaymentStatusForCheckoutSession)
    {
        url = aUrl;
        checkoutSession = new CheckoutSession(aIdForCheckoutSession, aCustomerForCheckoutSession, aLineItemsForCheckoutSession, aPaymentMethodForCheckoutSession, aPaymentStatusForCheckoutSession, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setUrl(String aUrl)
    {
        boolean wasSet = false;
        url = aUrl;
        wasSet = true;
        return wasSet;
    }

    public String getUrl()
    {
        return url;
    }
    /* Code from template association_GetOne */
    public CheckoutSession getCheckoutSession()
    {
        return checkoutSession;
    }
    /* Code from template association_GetOne_clear */
    protected void clear_checkoutSession()
    {
        checkoutSession = null;
    }

    public void delete()
    {
        CheckoutSession existingCheckoutSession = checkoutSession;
        checkoutSession = null;
        if (existingCheckoutSession != null)
        {
            existingCheckoutSession.delete();
        }
    }

    // line 173 "model.ump"
    public String receivePaymentRequest(paymentMethodId arg0){

    }

    // line 176 "model.ump"
    public void sendPaymentResponse(paymentIntentId arg0){

    }

    // line 179 "model.ump"
    public Payment createPayment(paymentMethod arg0, amount arg1, currency arg2){

    }

    // line 182 "model.ump"
    public void processPayment(payment arg0){

    }


    public String toString()
    {
        return super.toString() + "["+
                "url" + ":" + getUrl()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "checkoutSession = "+(getCheckoutSession()!=null?Integer.toHexString(System.identityHashCode(getCheckoutSession())):"null");
    }
}



//%% NEW FILE VerificationResponse BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 287 "model.ump"
// line 424 "model.ump"
public class VerificationResponse
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //VerificationResponse Attributes
    private String id;
    private VerificationStatus status;

    //VerificationResponse Associations
    private ThreeDSecure threeDSecure;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public VerificationResponse(String aId, VerificationStatus aStatus, ThreeDSecure aThreeDSecure)
    {
        id = aId;
        status = aStatus;
        if (aThreeDSecure == null || aThreeDSecure.getVerificationResponse() != null)
        {
            throw new RuntimeException("Unable to create VerificationResponse due to aThreeDSecure. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        threeDSecure = aThreeDSecure;
    }

    public VerificationResponse(String aId, VerificationStatus aStatus, String aIdForThreeDSecure, Payment aPaymentForThreeDSecure, VerificationStatus aStatusForThreeDSecure, CardIssuer aCardIssuerForThreeDSecure)
    {
        id = aId;
        status = aStatus;
        threeDSecure = new ThreeDSecure(aIdForThreeDSecure, aPaymentForThreeDSecure, aStatusForThreeDSecure, this, aCardIssuerForThreeDSecure);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(String aId)
    {
        boolean wasSet = false;
        id = aId;
        wasSet = true;
        return wasSet;
    }

    public boolean setStatus(VerificationStatus aStatus)
    {
        boolean wasSet = false;
        status = aStatus;
        wasSet = true;
        return wasSet;
    }

    public String getId()
    {
        return id;
    }

    public VerificationStatus getStatus()
    {
        return status;
    }
    /* Code from template association_GetOne */
    public ThreeDSecure getThreeDSecure()
    {
        return threeDSecure;
    }

    public void delete()
    {
        ThreeDSecure existingThreeDSecure = threeDSecure;
        threeDSecure = null;
        if (existingThreeDSecure != null)
        {
            existingThreeDSecure.delete();
        }
    }

    // line 293 "model.ump"
    public VerificationStatus getResponseStatus(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "status" + "=" + (getStatus() != null ? !getStatus().equals(this)  ? getStatus().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "threeDSecure = "+(getThreeDSecure()!=null?Integer.toHexString(System.identityHashCode(getThreeDSecure())):"null");
    }
}



//%% NEW FILE Address BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 13 "model.ump"
// line 307 "model.ump"
public class Address extends Customer
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Address Attributes
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Address(String aId, String aEmail, Address aShippingaddress, Order aOrder, String aStreet, String aCity, String aState, String aZip, String aCountry)
    {
        super(aId, aEmail, aShippingaddress, aOrder);
        street = aStreet;
        city = aCity;
        state = aState;
        zip = aZip;
        country = aCountry;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setStreet(String aStreet)
    {
        boolean wasSet = false;
        street = aStreet;
        wasSet = true;
        return wasSet;
    }

    public boolean setCity(String aCity)
    {
        boolean wasSet = false;
        city = aCity;
        wasSet = true;
        return wasSet;
    }

    public boolean setState(String aState)
    {
        boolean wasSet = false;
        state = aState;
        wasSet = true;
        return wasSet;
    }

    public boolean setZip(String aZip)
    {
        boolean wasSet = false;
        zip = aZip;
        wasSet = true;
        return wasSet;
    }

    public boolean setCountry(String aCountry)
    {
        boolean wasSet = false;
        country = aCountry;
        wasSet = true;
        return wasSet;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getZip()
    {
        return zip;
    }

    public String getCountry()
    {
        return country;
    }

    public void delete()
    {
        super.delete();
    }

    // line 23 "model.ump"
    public String getAddress(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "street" + ":" + getStreet()+ "," +
                "city" + ":" + getCity()+ "," +
                "state" + ":" + getState()+ "," +
                "zip" + ":" + getZip()+ "," +
                "country" + ":" + getCountry()+ "]";
    }
}



//%% NEW FILE Customer BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 301 "model.ump"
public class Customer
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Customer Attributes
    private String id;
    private String email;
    private Address shippingaddress;

    //Customer Associations
    private Order order;
    private List<CheckoutSession> checkoutSessions;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Customer(String aId, String aEmail, Address aShippingaddress, Order aOrder)
    {
        id = aId;
        email = aEmail;
        shippingaddress = aShippingaddress;
        if (aOrder == null || aOrder.getCustomer() != null)
        {
            throw new RuntimeException("Unable to create Customer due to aOrder. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        order = aOrder;
        checkoutSessions = new ArrayList<CheckoutSession>();
    }

    public Customer(String aId, String aEmail, Address aShippingaddress, String aIdForOrder, List aLineItemsForOrder, PaymentMethod aPaymentMethodForOrder, PaymentStatus aPaymentStatusForOrder, PaymentEndpoint aPaymentEndpointForOrder, double aAmountForOrder, String aCurrencyForOrder, paymentStatus aStatusForOrder, PaymentMethod aPaymentMethodForOrder, String aOrderIdForOrder, List aOrderItemsForOrder, Payment aPaymentForOrder, String aOrderStatusForOrder, WebhookEvent aWebhookEventForOrder)
    {
        id = aId;
        email = aEmail;
        shippingaddress = aShippingaddress;
        order = new Order(aIdForOrder, this, aLineItemsForOrder, aPaymentMethodForOrder, aPaymentStatusForOrder, aPaymentEndpointForOrder, aAmountForOrder, aCurrencyForOrder, aStatusForOrder, aPaymentMethodForOrder, aOrderIdForOrder, aOrderItemsForOrder, aPaymentForOrder, aOrderStatusForOrder, aWebhookEventForOrder, this);
        checkoutSessions = new ArrayList<CheckoutSession>();
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(String aId)
    {
        boolean wasSet = false;
        id = aId;
        wasSet = true;
        return wasSet;
    }

    public boolean setEmail(String aEmail)
    {
        boolean wasSet = false;
        email = aEmail;
        wasSet = true;
        return wasSet;
    }

    public boolean setShippingaddress(Address aShippingaddress)
    {
        boolean wasSet = false;
        shippingaddress = aShippingaddress;
        wasSet = true;
        return wasSet;
    }

    public String getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public Address getShippingaddress()
    {
        return shippingaddress;
    }
    /* Code from template association_GetOne */
    public Order getOrder()
    {
        return order;
    }
    /* Code from template association_GetMany */
    public CheckoutSession getCheckoutSession(int index)
    {
        CheckoutSession aCheckoutSession = checkoutSessions.get(index);
        return aCheckoutSession;
    }

    public List<CheckoutSession> getCheckoutSessions()
    {
        List<CheckoutSession> newCheckoutSessions = Collections.unmodifiableList(checkoutSessions);
        return newCheckoutSessions;
    }

    public int numberOfCheckoutSessions()
    {
        int number = checkoutSessions.size();
        return number;
    }

    public boolean hasCheckoutSessions()
    {
        boolean has = checkoutSessions.size() > 0;
        return has;
    }

    public int indexOfCheckoutSession(CheckoutSession aCheckoutSession)
    {
        int index = checkoutSessions.indexOf(aCheckoutSession);
        return index;
    }
    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfCheckoutSessions()
    {
        return 0;
    }
    /* Code from template association_AddManyToManyMethod */
    public boolean addCheckoutSession(CheckoutSession aCheckoutSession)
    {
        boolean wasAdded = false;
        if (checkoutSessions.contains(aCheckoutSession)) { return false; }
        checkoutSessions.add(aCheckoutSession);
        if (aCheckoutSession.indexOfCustomer(this) != -1)
        {
            wasAdded = true;
        }
        else
        {
            wasAdded = aCheckoutSession.addCustomer(this);
            if (!wasAdded)
            {
                checkoutSessions.remove(aCheckoutSession);
            }
        }
        return wasAdded;
    }
    /* Code from template association_RemoveMany */
    public boolean removeCheckoutSession(CheckoutSession aCheckoutSession)
    {
        boolean wasRemoved = false;
        if (!checkoutSessions.contains(aCheckoutSession))
        {
            return wasRemoved;
        }

        int oldIndex = checkoutSessions.indexOf(aCheckoutSession);
        checkoutSessions.remove(oldIndex);
        if (aCheckoutSession.indexOfCustomer(this) == -1)
        {
            wasRemoved = true;
        }
        else
        {
            wasRemoved = aCheckoutSession.removeCustomer(this);
            if (!wasRemoved)
            {
                checkoutSessions.add(oldIndex,aCheckoutSession);
            }
        }
        return wasRemoved;
    }
    /* Code from template association_AddIndexControlFunctions */
    public boolean addCheckoutSessionAt(CheckoutSession aCheckoutSession, int index)
    {
        boolean wasAdded = false;
        if(addCheckoutSession(aCheckoutSession))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfCheckoutSessions()) { index = numberOfCheckoutSessions() - 1; }
            checkoutSessions.remove(aCheckoutSession);
            checkoutSessions.add(index, aCheckoutSession);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveCheckoutSessionAt(CheckoutSession aCheckoutSession, int index)
    {
        boolean wasAdded = false;
        if(checkoutSessions.contains(aCheckoutSession))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfCheckoutSessions()) { index = numberOfCheckoutSessions() - 1; }
            checkoutSessions.remove(aCheckoutSession);
            checkoutSessions.add(index, aCheckoutSession);
            wasAdded = true;
        }
        else
        {
            wasAdded = addCheckoutSessionAt(aCheckoutSession, index);
        }
        return wasAdded;
    }

    public void delete()
    {
        Order existingOrder = order;
        order = null;
        if (existingOrder != null)
        {
            existingOrder.delete();
        }
        ArrayList<CheckoutSession> copyOfCheckoutSessions = new ArrayList<CheckoutSession>(checkoutSessions);
        checkoutSessions.clear();
        for(CheckoutSession aCheckoutSession : copyOfCheckoutSessions)
        {
            aCheckoutSession.removeCustomer(this);
        }
    }

    // line 10 "model.ump"
    public CustomerDetails getCustomerDetails(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "id" + ":" + getId()+ "," +
                "email" + ":" + getEmail()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "shippingaddress" + "=" + (getShippingaddress() != null ? !getShippingaddress().equals(this)  ? getShippingaddress().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null");
    }
}



//%% NEW FILE OrderFullfillment BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 105 "model.ump"
// line 337 "model.ump"
public class OrderFullfillment extends WebhookHandler
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public OrderFullfillment(OrderFullfillment aOrderFullfillment)
    {
        super(aOrderFullfillment);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public void delete()
    {
        super.delete();
    }

    // line 110 "model.ump"
    public void processOrder(order arg0){

    }

    // line 113 "model.ump"
    public void sendConfirmation(order arg0){

    }

}



//%% NEW FILE ApplePay BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 232 "model.ump"
// line 392 "model.ump"
public class ApplePay extends PaymentMethod
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //ApplePay Attributes
    private String applePayToken;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public ApplePay(String aId, String aName, Payment aPayment, String aApplePayToken)
    {
        super(aId, aName, aPayment);
        applePayToken = aApplePayToken;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setApplePayToken(String aApplePayToken)
    {
        boolean wasSet = false;
        applePayToken = aApplePayToken;
        wasSet = true;
        return wasSet;
    }

    public String getApplePayToken()
    {
        return applePayToken;
    }

    public void delete()
    {
        super.delete();
    }

    // line 238 "model.ump"
    public Payment processPayment(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "applePayToken" + ":" + getApplePayToken()+ "]";
    }
}



//%% NEW FILE LineItem BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 52 "model.ump"
// line 318 "model.ump"
public class LineItem extends CheckoutSession
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //LineItem Attributes
    private String description;
    private float amount;
    private String currency;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public LineItem(String aId, Customer aCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint, String aDescription, float aAmount, String aCurrency)
    {
        super(aId, aCustomer, aLineItems, aPaymentMethod, aPaymentStatus, aPaymentEndpoint);
        description = aDescription;
        amount = aAmount;
        currency = aCurrency;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setDescription(String aDescription)
    {
        boolean wasSet = false;
        description = aDescription;
        wasSet = true;
        return wasSet;
    }

    public boolean setAmount(float aAmount)
    {
        boolean wasSet = false;
        amount = aAmount;
        wasSet = true;
        return wasSet;
    }

    public boolean setCurrency(String aCurrency)
    {
        boolean wasSet = false;
        currency = aCurrency;
        wasSet = true;
        return wasSet;
    }

    public String getDescription()
    {
        return description;
    }

    public float getAmount()
    {
        return amount;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void delete()
    {
        super.delete();
    }

    // line 61 "model.ump"
    public LineItemDetails getLineItemDetails(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "description" + ":" + getDescription()+ "," +
                "amount" + ":" + getAmount()+ "," +
                "currency" + ":" + getCurrency()+ "]";
    }
}



//%% NEW FILE FailedTransaction BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 82 "model.ump"
// line 331 "model.ump"
public class FailedTransaction
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //FailedTransaction Attributes
    private String transactionId;
    private String errorCode;
    private String errorMessage;

    //FailedTransaction Associations
    private WebhookEvent webhookEvent;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public FailedTransaction(String aTransactionId, String aErrorCode, String aErrorMessage, WebhookEvent aWebhookEvent)
    {
        transactionId = aTransactionId;
        errorCode = aErrorCode;
        errorMessage = aErrorMessage;
        if (aWebhookEvent == null || aWebhookEvent.getFailedTransaction() != null)
        {
            throw new RuntimeException("Unable to create FailedTransaction due to aWebhookEvent. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        webhookEvent = aWebhookEvent;
    }

    public FailedTransaction(String aTransactionId, String aErrorCode, String aErrorMessage, String aEventTypeForWebhookEvent, Map aEventDataForWebhookEvent, Order aOrderForWebhookEvent)
    {
        transactionId = aTransactionId;
        errorCode = aErrorCode;
        errorMessage = aErrorMessage;
        webhookEvent = new WebhookEvent(aEventTypeForWebhookEvent, aEventDataForWebhookEvent, aOrderForWebhookEvent, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setTransactionId(String aTransactionId)
    {
        boolean wasSet = false;
        transactionId = aTransactionId;
        wasSet = true;
        return wasSet;
    }

    public boolean setErrorCode(String aErrorCode)
    {
        boolean wasSet = false;
        errorCode = aErrorCode;
        wasSet = true;
        return wasSet;
    }

    public boolean setErrorMessage(String aErrorMessage)
    {
        boolean wasSet = false;
        errorMessage = aErrorMessage;
        wasSet = true;
        return wasSet;
    }

    public String getTransactionId()
    {
        return transactionId;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
    /* Code from template association_GetOne */
    public WebhookEvent getWebhookEvent()
    {
        return webhookEvent;
    }

    public void delete()
    {
        WebhookEvent existingWebhookEvent = webhookEvent;
        webhookEvent = null;
        if (existingWebhookEvent != null)
        {
            existingWebhookEvent.delete();
        }
    }

    // line 90 "model.ump"
    public void processEvent(WebhookEvent arg0){

    }

    // line 93 "model.ump"
    public void notifyCustomer(FailedTransaction arg0){

    }

    // line 96 "model.ump"
    public void logError(FailedTransaction arg0){

    }


    public String toString()
    {
        return super.toString() + "["+
                "transactionId" + ":" + getTransactionId()+ "," +
                "errorCode" + ":" + getErrorCode()+ "," +
                "errorMessage" + ":" + getErrorMessage()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "webhookEvent = "+(getWebhookEvent()!=null?Integer.toHexString(System.identityHashCode(getWebhookEvent())):"null");
    }
}



//%% NEW FILE ErrorLog BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 116 "model.ump"
// line 342 "model.ump"
public class ErrorLog extends FailedTransaction
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //ErrorLog Attributes
    private List errorEntries;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public ErrorLog(String aTransactionId, String aErrorCode, String aErrorMessage, WebhookEvent aWebhookEvent, List aErrorEntries)
    {
        super(aTransactionId, aErrorCode, aErrorMessage, aWebhookEvent);
        errorEntries = aErrorEntries;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setErrorEntries(List aErrorEntries)
    {
        boolean wasSet = false;
        errorEntries = aErrorEntries;
        wasSet = true;
        return wasSet;
    }

    public List getErrorEntries()
    {
        return errorEntries;
    }

    public void delete()
    {
        super.delete();
    }

    // line 122 "model.ump"
    public void logError(errorEntry arg0){

    }


    public String toString()
    {
        return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "errorEntries" + "=" + (getErrorEntries() != null ? !getErrorEntries().equals(this)  ? getErrorEntries().toString().replaceAll("  ","    ") : "this" : "null");
    }
}



//%% NEW FILE CardIssuer BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 263 "model.ump"
// line 412 "model.ump"
public class CardIssuer
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //CardIssuer Attributes
    private String id;
    private String name;

    //CardIssuer Associations
    private ThreeDSecure threeDSecure;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public CardIssuer(String aId, String aName, ThreeDSecure aThreeDSecure)
    {
        id = aId;
        name = aName;
        if (aThreeDSecure == null || aThreeDSecure.getCardIssuer() != null)
        {
            throw new RuntimeException("Unable to create CardIssuer due to aThreeDSecure. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        threeDSecure = aThreeDSecure;
    }

    public CardIssuer(String aId, String aName, String aIdForThreeDSecure, Payment aPaymentForThreeDSecure, VerificationStatus aStatusForThreeDSecure, VerificationResponse aVerificationResponseForThreeDSecure)
    {
        id = aId;
        name = aName;
        threeDSecure = new ThreeDSecure(aIdForThreeDSecure, aPaymentForThreeDSecure, aStatusForThreeDSecure, aVerificationResponseForThreeDSecure, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(String aId)
    {
        boolean wasSet = false;
        id = aId;
        wasSet = true;
        return wasSet;
    }

    public boolean setName(String aName)
    {
        boolean wasSet = false;
        name = aName;
        wasSet = true;
        return wasSet;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
    /* Code from template association_GetOne */
    public ThreeDSecure getThreeDSecure()
    {
        return threeDSecure;
    }

    public void delete()
    {
        ThreeDSecure existingThreeDSecure = threeDSecure;
        threeDSecure = null;
        if (existingThreeDSecure != null)
        {
            existingThreeDSecure.delete();
        }
    }

    // line 270 "model.ump"
    public verificationResponse authenticate(customer arg0, threeDSecure arg1){

    }


    public String toString()
    {
        return super.toString() + "["+
                "id" + ":" + getId()+ "," +
                "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "threeDSecure = "+(getThreeDSecure()!=null?Integer.toHexString(System.identityHashCode(getThreeDSecure())):"null");
    }
}



//%% NEW FILE Payment BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 185 "model.ump"
// line 373 "model.ump"
public class Payment extends CheckoutSession
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Payment Attributes
    private double amount;
    private String currency;
    private paymentStatus status;

    //Payment Associations
    private PaymentMethod paymentMethod;
    private List<ThreeDSecure> threeDSecures;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Payment(String aId, Customer aCustomer, List aLineItems, PaymentMethod aPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint, double aAmount, String aCurrency, paymentStatus aStatus, PaymentMethod aPaymentMethod)
    {
        super(aId, aCustomer, aLineItems, aPaymentMethod, aPaymentStatus, aPaymentEndpoint);
        amount = aAmount;
        currency = aCurrency;
        status = aStatus;
        if (aPaymentMethod == null || aPaymentMethod.getPayment() != null)
        {
            throw new RuntimeException("Unable to create Payment due to aPaymentMethod. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        paymentMethod = aPaymentMethod;
        threeDSecures = new ArrayList<ThreeDSecure>();
    }

    public Payment(String aId, Customer aCustomer, List aLineItems, String aIdForPaymentMethod, String aNameForPaymentMethod, PaymentStatus aPaymentStatus, PaymentEndpoint aPaymentEndpoint, double aAmount, String aCurrency, paymentStatus aStatus, String aIdForPaymentMethod, String aNameForPaymentMethod)
    {
        super(aId, aCustomer, aLineItems, aPaymentMethod, aPaymentStatus, aPaymentEndpoint);
        amount = aAmount;
        currency = aCurrency;
        status = aStatus;
        paymentMethod = new PaymentMethod(aIdForPaymentMethod, aNameForPaymentMethod, this);
        threeDSecures = new ArrayList<ThreeDSecure>();
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setAmount(double aAmount)
    {
        boolean wasSet = false;
        amount = aAmount;
        wasSet = true;
        return wasSet;
    }

    public boolean setCurrency(String aCurrency)
    {
        boolean wasSet = false;
        currency = aCurrency;
        wasSet = true;
        return wasSet;
    }

    public boolean setStatus(paymentStatus aStatus)
    {
        boolean wasSet = false;
        status = aStatus;
        wasSet = true;
        return wasSet;
    }

    public double getAmount()
    {
        return amount;
    }

    public String getCurrency()
    {
        return currency;
    }

    public paymentStatus getStatus()
    {
        return status;
    }
    /* Code from template association_GetOne */
    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }
    /* Code from template association_GetMany */
    public ThreeDSecure getThreeDSecure(int index)
    {
        ThreeDSecure aThreeDSecure = threeDSecures.get(index);
        return aThreeDSecure;
    }

    public List<ThreeDSecure> getThreeDSecures()
    {
        List<ThreeDSecure> newThreeDSecures = Collections.unmodifiableList(threeDSecures);
        return newThreeDSecures;
    }

    public int numberOfThreeDSecures()
    {
        int number = threeDSecures.size();
        return number;
    }

    public boolean hasThreeDSecures()
    {
        boolean has = threeDSecures.size() > 0;
        return has;
    }

    public int indexOfThreeDSecure(ThreeDSecure aThreeDSecure)
    {
        int index = threeDSecures.indexOf(aThreeDSecure);
        return index;
    }
    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfThreeDSecures()
    {
        return 0;
    }
    /* Code from template association_AddManyToManyMethod */
    public boolean addThreeDSecure(ThreeDSecure aThreeDSecure)
    {
        boolean wasAdded = false;
        if (threeDSecures.contains(aThreeDSecure)) { return false; }
        threeDSecures.add(aThreeDSecure);
        if (aThreeDSecure.indexOfPayment(this) != -1)
        {
            wasAdded = true;
        }
        else
        {
            wasAdded = aThreeDSecure.addPayment(this);
            if (!wasAdded)
            {
                threeDSecures.remove(aThreeDSecure);
            }
        }
        return wasAdded;
    }
    /* Code from template association_RemoveMany */
    public boolean removeThreeDSecure(ThreeDSecure aThreeDSecure)
    {
        boolean wasRemoved = false;
        if (!threeDSecures.contains(aThreeDSecure))
        {
            return wasRemoved;
        }

        int oldIndex = threeDSecures.indexOf(aThreeDSecure);
        threeDSecures.remove(oldIndex);
        if (aThreeDSecure.indexOfPayment(this) == -1)
        {
            wasRemoved = true;
        }
        else
        {
            wasRemoved = aThreeDSecure.removePayment(this);
            if (!wasRemoved)
            {
                threeDSecures.add(oldIndex,aThreeDSecure);
            }
        }
        return wasRemoved;
    }
    /* Code from template association_AddIndexControlFunctions */
    public boolean addThreeDSecureAt(ThreeDSecure aThreeDSecure, int index)
    {
        boolean wasAdded = false;
        if(addThreeDSecure(aThreeDSecure))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfThreeDSecures()) { index = numberOfThreeDSecures() - 1; }
            threeDSecures.remove(aThreeDSecure);
            threeDSecures.add(index, aThreeDSecure);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveThreeDSecureAt(ThreeDSecure aThreeDSecure, int index)
    {
        boolean wasAdded = false;
        if(threeDSecures.contains(aThreeDSecure))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfThreeDSecures()) { index = numberOfThreeDSecures() - 1; }
            threeDSecures.remove(aThreeDSecure);
            threeDSecures.add(index, aThreeDSecure);
            wasAdded = true;
        }
        else
        {
            wasAdded = addThreeDSecureAt(aThreeDSecure, index);
        }
        return wasAdded;
    }

    public void delete()
    {
        PaymentMethod existingPaymentMethod = paymentMethod;
        paymentMethod = null;
        if (existingPaymentMethod != null)
        {
            existingPaymentMethod.delete();
        }
        ArrayList<ThreeDSecure> copyOfThreeDSecures = new ArrayList<ThreeDSecure>(threeDSecures);
        threeDSecures.clear();
        for(ThreeDSecure aThreeDSecure : copyOfThreeDSecures)
        {
            aThreeDSecure.removePayment(this);
        }
        super.delete();
    }

    // line 199 "model.ump"
    public Payment create(amount arg0, currency arg1, paymentMethod arg2){

    }

    // line 202 "model.ump"
    public VerificationResponse process(){

    }

    // line 205 "model.ump"
    public void initiateSecureVerification(){

    }

    // line 208 "model.ump"
    public Order handleCompletedTransaction(verificationResponse arg0){

    }


    public String toString()
    {
        return super.toString() + "["+
                "amount" + ":" + getAmount()+ "," +
                "currency" + ":" + getCurrency()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "status" + "=" + (getStatus() != null ? !getStatus().equals(this)  ? getStatus().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "paymentMethod = "+(getPaymentMethod()!=null?Integer.toHexString(System.identityHashCode(getPaymentMethod())):"null");
    }
    //------------------------
    // DEVELOPER CODE - PROVIDED AS-IS
    //------------------------

    // line 193 "model.ump"
  * --  ThreeDSecure ;


}



//%% NEW FILE CreditDebitCard BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 220 "model.ump"
// line 387 "model.ump"
public class CreditDebitCard extends PaymentMethod
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //CreditDebitCard Attributes
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public CreditDebitCard(String aId, String aName, Payment aPayment, String aCardNumber, String aCardHolderName, String aExpiryDate, String aCvv)
    {
        super(aId, aName, aPayment);
        cardNumber = aCardNumber;
        cardHolderName = aCardHolderName;
        expiryDate = aExpiryDate;
        cvv = aCvv;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setCardNumber(String aCardNumber)
    {
        boolean wasSet = false;
        cardNumber = aCardNumber;
        wasSet = true;
        return wasSet;
    }

    public boolean setCardHolderName(String aCardHolderName)
    {
        boolean wasSet = false;
        cardHolderName = aCardHolderName;
        wasSet = true;
        return wasSet;
    }

    public boolean setExpiryDate(String aExpiryDate)
    {
        boolean wasSet = false;
        expiryDate = aExpiryDate;
        wasSet = true;
        return wasSet;
    }

    public boolean setCvv(String aCvv)
    {
        boolean wasSet = false;
        cvv = aCvv;
        wasSet = true;
        return wasSet;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public String getCardHolderName()
    {
        return cardHolderName;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public String getCvv()
    {
        return cvv;
    }

    public void delete()
    {
        super.delete();
    }

    // line 229 "model.ump"
    public Payment processPayment(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "cardNumber" + ":" + getCardNumber()+ "," +
                "cardHolderName" + ":" + getCardHolderName()+ "," +
                "expiryDate" + ":" + getExpiryDate()+ "," +
                "cvv" + ":" + getCvv()+ "]";
    }
}



//%% NEW FILE WebhookHandler BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 128 "model.ump"
// line 347 "model.ump"
public class WebhookHandler
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //WebhookHandler Attributes
    private OrderFullfillment orderFullfillment;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public WebhookHandler(OrderFullfillment aOrderFullfillment)
    {
        orderFullfillment = aOrderFullfillment;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setOrderFullfillment(OrderFullfillment aOrderFullfillment)
    {
        boolean wasSet = false;
        orderFullfillment = aOrderFullfillment;
        wasSet = true;
        return wasSet;
    }

    public OrderFullfillment getOrderFullfillment()
    {
        return orderFullfillment;
    }

    public void delete()
    {}

    // line 133 "model.ump"
    public void processEvent(event arg0){

    }

    // line 136 "model.ump"
    public Order createOrder(event arg0){

    }

    // line 139 "model.ump"
    public void handleFailedTransactions(WebhookEvent arg0){

    }


    public String toString()
    {
        return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "orderFullfillment" + "=" + (getOrderFullfillment() != null ? !getOrderFullfillment().equals(this)  ? getOrderFullfillment().toString().replaceAll("  ","    ") : "this" : "null");
    }
}



//%% NEW FILE NewClass1 BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 259 "model.ump"
// line 407 "model.ump"
public class NewClass1
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public NewClass1()
    {}

    //------------------------
    // INTERFACE
    //------------------------

    public void delete()
    {}

}



//%% NEW FILE WebhookEvent BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 142 "model.ump"
// line 352 "model.ump"
public class WebhookEvent
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //WebhookEvent Attributes
    private String eventType;
    private Map eventData;

    //WebhookEvent Associations
    private Order order;
    private FailedTransaction failedTransaction;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public WebhookEvent(String aEventType, Map aEventData, Order aOrder, FailedTransaction aFailedTransaction)
    {
        eventType = aEventType;
        eventData = aEventData;
        if (aOrder == null || aOrder.getWebhookEvent() != null)
        {
            throw new RuntimeException("Unable to create WebhookEvent due to aOrder. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        order = aOrder;
        if (aFailedTransaction == null || aFailedTransaction.getWebhookEvent() != null)
        {
            throw new RuntimeException("Unable to create WebhookEvent due to aFailedTransaction. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        failedTransaction = aFailedTransaction;
    }

    public WebhookEvent(String aEventType, Map aEventData, String aIdForOrder, Customer aCustomerForOrder, List aLineItemsForOrder, PaymentMethod aPaymentMethodForOrder, PaymentStatus aPaymentStatusForOrder, PaymentEndpoint aPaymentEndpointForOrder, double aAmountForOrder, String aCurrencyForOrder, paymentStatus aStatusForOrder, PaymentMethod aPaymentMethodForOrder, String aOrderIdForOrder, List aOrderItemsForOrder, Payment aPaymentForOrder, String aOrderStatusForOrder, Customer aCustomerForOrder, String aTransactionIdForFailedTransaction, String aErrorCodeForFailedTransaction, String aErrorMessageForFailedTransaction)
    {
        eventType = aEventType;
        eventData = aEventData;
        order = new Order(aIdForOrder, aCustomerForOrder, aLineItemsForOrder, aPaymentMethodForOrder, aPaymentStatusForOrder, aPaymentEndpointForOrder, aAmountForOrder, aCurrencyForOrder, aStatusForOrder, aPaymentMethodForOrder, aOrderIdForOrder, aOrderItemsForOrder, aPaymentForOrder, aOrderStatusForOrder, this, aCustomerForOrder);
        failedTransaction = new FailedTransaction(aTransactionIdForFailedTransaction, aErrorCodeForFailedTransaction, aErrorMessageForFailedTransaction, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setEventType(String aEventType)
    {
        boolean wasSet = false;
        eventType = aEventType;
        wasSet = true;
        return wasSet;
    }

    public boolean setEventData(Map aEventData)
    {
        boolean wasSet = false;
        eventData = aEventData;
        wasSet = true;
        return wasSet;
    }

    public String getEventType()
    {
        return eventType;
    }

    public Map getEventData()
    {
        return eventData;
    }
    /* Code from template association_GetOne */
    public Order getOrder()
    {
        return order;
    }
    /* Code from template association_GetOne */
    public FailedTransaction getFailedTransaction()
    {
        return failedTransaction;
    }

    public void delete()
    {
        Order existingOrder = order;
        order = null;
        if (existingOrder != null)
        {
            existingOrder.delete();
        }
        FailedTransaction existingFailedTransaction = failedTransaction;
        failedTransaction = null;
        if (existingFailedTransaction != null)
        {
            existingFailedTransaction.delete();
        }
    }


    public String toString()
    {
        return super.toString() + "["+
                "eventType" + ":" + getEventType()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "eventData" + "=" + (getEventData() != null ? !getEventData().equals(this)  ? getEventData().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null") + System.getProperties().getProperty("line.separator") +
                "  " + "failedTransaction = "+(getFailedTransaction()!=null?Integer.toHexString(System.identityHashCode(getFailedTransaction())):"null");
    }
}



//%% NEW FILE ThreeDSecure BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 273 "model.ump"
// line 418 "model.ump"
public class ThreeDSecure
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //ThreeDSecure Attributes
    private String id;
    private Payment payment;
    private VerificationStatus status;

    //ThreeDSecure Associations
    private VerificationResponse verificationResponse;
    private List<Payment> payments;
    private CardIssuer cardIssuer;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public ThreeDSecure(String aId, Payment aPayment, VerificationStatus aStatus, VerificationResponse aVerificationResponse, CardIssuer aCardIssuer)
    {
        id = aId;
        payment = aPayment;
        status = aStatus;
        if (aVerificationResponse == null || aVerificationResponse.getThreeDSecure() != null)
        {
            throw new RuntimeException("Unable to create ThreeDSecure due to aVerificationResponse. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        verificationResponse = aVerificationResponse;
        payments = new ArrayList<Payment>();
        if (aCardIssuer == null || aCardIssuer.getThreeDSecure() != null)
        {
            throw new RuntimeException("Unable to create ThreeDSecure due to aCardIssuer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        cardIssuer = aCardIssuer;
    }

    public ThreeDSecure(String aId, Payment aPayment, VerificationStatus aStatus, String aIdForVerificationResponse, VerificationStatus aStatusForVerificationResponse, String aIdForCardIssuer, String aNameForCardIssuer)
    {
        id = aId;
        payment = aPayment;
        status = aStatus;
        verificationResponse = new VerificationResponse(aIdForVerificationResponse, aStatusForVerificationResponse, this);
        payments = new ArrayList<Payment>();
        cardIssuer = new CardIssuer(aIdForCardIssuer, aNameForCardIssuer, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(String aId)
    {
        boolean wasSet = false;
        id = aId;
        wasSet = true;
        return wasSet;
    }

    public boolean setPayment(Payment aPayment)
    {
        boolean wasSet = false;
        payment = aPayment;
        wasSet = true;
        return wasSet;
    }

    public boolean setStatus(VerificationStatus aStatus)
    {
        boolean wasSet = false;
        status = aStatus;
        wasSet = true;
        return wasSet;
    }

    public String getId()
    {
        return id;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public VerificationStatus getStatus()
    {
        return status;
    }
    /* Code from template association_GetOne */
    public VerificationResponse getVerificationResponse()
    {
        return verificationResponse;
    }
    /* Code from template association_GetMany */
    public Payment getPayment(int index)
    {
        Payment aPayment = payments.get(index);
        return aPayment;
    }

    public List<Payment> getPayments()
    {
        List<Payment> newPayments = Collections.unmodifiableList(payments);
        return newPayments;
    }

    public int numberOfPayments()
    {
        int number = payments.size();
        return number;
    }

    public boolean hasPayments()
    {
        boolean has = payments.size() > 0;
        return has;
    }

    public int indexOfPayment(Payment aPayment)
    {
        int index = payments.indexOf(aPayment);
        return index;
    }
    /* Code from template association_GetOne */
    public CardIssuer getCardIssuer()
    {
        return cardIssuer;
    }
    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfPayments()
    {
        return 0;
    }
    /* Code from template association_AddManyToManyMethod */
    public boolean addPayment(Payment aPayment)
    {
        boolean wasAdded = false;
        if (payments.contains(aPayment)) { return false; }
        payments.add(aPayment);
        if (aPayment.indexOfThreeDSecure(this) != -1)
        {
            wasAdded = true;
        }
        else
        {
            wasAdded = aPayment.addThreeDSecure(this);
            if (!wasAdded)
            {
                payments.remove(aPayment);
            }
        }
        return wasAdded;
    }
    /* Code from template association_RemoveMany */
    public boolean removePayment(Payment aPayment)
    {
        boolean wasRemoved = false;
        if (!payments.contains(aPayment))
        {
            return wasRemoved;
        }

        int oldIndex = payments.indexOf(aPayment);
        payments.remove(oldIndex);
        if (aPayment.indexOfThreeDSecure(this) == -1)
        {
            wasRemoved = true;
        }
        else
        {
            wasRemoved = aPayment.removeThreeDSecure(this);
            if (!wasRemoved)
            {
                payments.add(oldIndex,aPayment);
            }
        }
        return wasRemoved;
    }
    /* Code from template association_AddIndexControlFunctions */
    public boolean addPaymentAt(Payment aPayment, int index)
    {
        boolean wasAdded = false;
        if(addPayment(aPayment))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfPayments()) { index = numberOfPayments() - 1; }
            payments.remove(aPayment);
            payments.add(index, aPayment);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMovePaymentAt(Payment aPayment, int index)
    {
        boolean wasAdded = false;
        if(payments.contains(aPayment))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfPayments()) { index = numberOfPayments() - 1; }
            payments.remove(aPayment);
            payments.add(index, aPayment);
            wasAdded = true;
        }
        else
        {
            wasAdded = addPaymentAt(aPayment, index);
        }
        return wasAdded;
    }

    public void delete()
    {
        VerificationResponse existingVerificationResponse = verificationResponse;
        verificationResponse = null;
        if (existingVerificationResponse != null)
        {
            existingVerificationResponse.delete();
        }
        ArrayList<Payment> copyOfPayments = new ArrayList<Payment>(payments);
        payments.clear();
        for(Payment aPayment : copyOfPayments)
        {
            aPayment.removeThreeDSecure(this);
        }
        CardIssuer existingCardIssuer = cardIssuer;
        cardIssuer = null;
        if (existingCardIssuer != null)
        {
            existingCardIssuer.delete();
        }
    }

    // line 281 "model.ump"
    public void initiateVerification(){

    }

    // line 284 "model.ump"
    public void updatePaymentStatus(response arg0){

    }


    public String toString()
    {
        return super.toString() + "["+
                "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "payment" + "=" + (getPayment() != null ? !getPayment().equals(this)  ? getPayment().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "status" + "=" + (getStatus() != null ? !getStatus().equals(this)  ? getStatus().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
                "  " + "verificationResponse = "+(getVerificationResponse()!=null?Integer.toHexString(System.identityHashCode(getVerificationResponse())):"null") + System.getProperties().getProperty("line.separator") +
                "  " + "cardIssuer = "+(getCardIssuer()!=null?Integer.toHexString(System.identityHashCode(getCardIssuer())):"null");
    }
}



//%% NEW FILE PaymentMethod BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 211 "model.ump"
// line 382 "model.ump"
public class PaymentMethod
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //PaymentMethod Attributes
    private String id;
    private String name;

    //PaymentMethod Associations
    private Payment payment;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public PaymentMethod(String aId, String aName, Payment aPayment)
    {
        id = aId;
        name = aName;
        if (aPayment == null || aPayment.getPaymentMethod() != null)
        {
            throw new RuntimeException("Unable to create PaymentMethod due to aPayment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        payment = aPayment;
    }

    public PaymentMethod(String aId, String aName, String aIdForPayment, Customer aCustomerForPayment, List aLineItemsForPayment, PaymentStatus aPaymentStatusForPayment, PaymentEndpoint aPaymentEndpointForPayment, double aAmountForPayment, String aCurrencyForPayment, paymentStatus aStatusForPayment)
    {
        id = aId;
        name = aName;
        payment = new Payment(aIdForPayment, aCustomerForPayment, aLineItemsForPayment, this, aPaymentStatusForPayment, aPaymentEndpointForPayment, aAmountForPayment, aCurrencyForPayment, aStatusForPayment, this);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(String aId)
    {
        boolean wasSet = false;
        id = aId;
        wasSet = true;
        return wasSet;
    }

    public boolean setName(String aName)
    {
        boolean wasSet = false;
        name = aName;
        wasSet = true;
        return wasSet;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
    /* Code from template association_GetOne */
    public Payment getPayment()
    {
        return payment;
    }

    public void delete()
    {
        Payment existingPayment = payment;
        payment = null;
        if (existingPayment != null)
        {
            existingPayment.delete();
        }
    }

    // line 217 "model.ump"
    public Payment processpayment(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "id" + ":" + getId()+ "," +
                "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
                "  " + "payment = "+(getPayment()!=null?Integer.toHexString(System.identityHashCode(getPayment())):"null");
    }
}



//%% NEW FILE GooglePay BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 241 "model.ump"
// line 397 "model.ump"
public class GooglePay extends PaymentMethod
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //GooglePay Attributes
    private String googlePayToken;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public GooglePay(String aId, String aName, Payment aPayment, String aGooglePayToken)
    {
        super(aId, aName, aPayment);
        googlePayToken = aGooglePayToken;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setGooglePayToken(String aGooglePayToken)
    {
        boolean wasSet = false;
        googlePayToken = aGooglePayToken;
        wasSet = true;
        return wasSet;
    }

    public String getGooglePayToken()
    {
        return googlePayToken;
    }

    public void delete()
    {
        super.delete();
    }

    // line 247 "model.ump"
    public Payment processPayment(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "googlePayToken" + ":" + getGooglePayToken()+ "]";
    }
}



//%% NEW FILE NewClass BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 154 "model.ump"
// line 357 "model.ump"
public class NewClass
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public NewClass()
    {}

    //------------------------
    // INTERFACE
    //------------------------

    public void delete()
    {}

}