package com.sutao.client;

import com.sutao.behavior.command.Commander;
import com.sutao.behavior.state.ConcreteStateA;
import com.sutao.behavior.state.StateContext;
import com.sutao.behavior.strategy.StrategyContext;
import com.sutao.behavior.strategy.StrategyImp2;
import com.sutao.behavior.strategy.StrategyImpl1;
import com.sutao.behavior.template.ConcreteMethod1;
import com.sutao.behavior.template.ConcreteMethod2;
import com.sutao.behavior.template.Template;
import com.sutao.creator.AbstractFactory.HAIERFactory;
import com.sutao.creator.AbstractFactory.IAbstractFactory;
import com.sutao.creator.AbstractFactory.TCLFactory;
import com.sutao.creator.FactoryMethod.ConcreteFactory1;
import com.sutao.creator.FactoryMethod.ConcreteFactory2;
import com.sutao.creator.FactoryMethod.IFactory;
import com.sutao.creator.SimpleFactory.SimpleFactory;
import com.sutao.creator.builder.KFCMealBuilder;
import com.sutao.creator.builder.KFCWaiter;
import com.sutao.creator.builder.Meal;
import com.sutao.creator.singleton.Singleton;
import com.sutao.struct.adapter.Adaptee;
import com.sutao.struct.adapter.Adapter;
import com.sutao.struct.adapter.Target;
import com.sutao.struct.bridge.*;
import com.sutao.struct.composite.Composite;
import com.sutao.struct.composite.Leaf;
import com.sutao.struct.decorator.ConcreteComponent;
import com.sutao.struct.decorator.ConcreteDecorator;
import com.sutao.struct.facade.Facade;
import com.sutao.struct.flyweight.FlyweightFactory;
import com.sutao.struct.proxy.dynamic.IProxy;
import com.sutao.struct.proxy.dynamic.LogHandle;
import com.sutao.struct.proxy.dynamic.RelSub;
import com.sutao.struct.proxy.sta.Proxy;

public class TestCases {

    @Test
    public void	testSimpleFactory()
    {
        SimpleFactory.createProduct(SimpleFactory.PRODUCT_TYPE.A).display();
        SimpleFactory.createProduct(SimpleFactory.PRODUCT_TYPE.B).display();
    }

    @Test
    public void testFactoryMethod()
    {
        IFactory factory1 = new ConcreteFactory1();
        factory1.CreateProduct().display();
        IFactory factory2 = new ConcreteFactory2();
        factory2.CreateProduct().display();
    }

    @Test
    public void testAbstractFactory()
    {
        IAbstractFactory af1 = new HAIERFactory();
        af1.CreateProductA().use();
        af1.CreateProductB().display();
        IAbstractFactory af2 = new TCLFactory();
        af2.CreateProductA().use();
        af2.CreateProductB().display();
    }

    @Test
    public void testBuilder()
    {
        KFCWaiter waiter = new KFCWaiter();
        waiter.setMealBuilder(new KFCMealBuilder());
        Meal meal = waiter.construct();
        System.out.println(meal);
    }

    @Test
    public void testSingleton ()
    {
        Singleton.getInstance1().operation();
        Singleton.getInstance2().operation();
    }

    @Test
    public void testAdapter()
    {
        Target t = new Adapter(new Adaptee());
        t.request();
    }

    @Test
    public void testBridge()
    {
        IPaint imp = new PaintGreen();
        Shape a = new RectangleShape(imp);
        a.draw();
        Shape b = new RectangleShape(new PaintRed());
        b.draw();
    }

    @Test
    public void testDecorator()
    {
        new ConcreteDecorator(new ConcreteComponent()).operation();
    }

    @Test
    public void testFlyweight () {
      FlyweightFactory factory = new FlyweightFactory();
      factory.getFlyweight("obj1").operation();
      factory.getFlyweight("obj2").operation();
      factory.getFlyweight("obj1").operation();
      factory.getFlyweight("obj1").operation();
      factory.getFlyweight("obj1").operation();
      System.out.println(factory.getSize());
    }

    public static void testComposite()
    {
        Leaf l1 = new Leaf("child1");
        Composite p1 = new Composite("parent1");
        p1.AddChild(l1);
        Leaf l2 = new Leaf("child2");
        Leaf l3 = new Leaf("child3");
        Composite p2 = new Composite("parent2");
        p2.AddChild(p1);
        p2.AddChild(l2);
        p2.AddChild(l3);
        p2.operation();
        p1.RemoveChild(l1);
        p2.operation();
    }

    @Test
    public static void testFacade()
    {
        Facade f = new Facade();
        f.OperationWrapper();
    }

    @Test
    public static void testStaticProxy()
    {
        Proxy p = new Proxy();
        p.operation();
    }

    @Test
    public static void testDynamicProxy()
    {
      LogHandle logHandle = new LogHandle();
      IProxy proxy = (IProxy) logHandle.newProxyObject(new RelSub());
      proxy.operation();
    }

    public static void testTemplate()
    {
        Template t = new ConcreteMethod1();
        t.templateMethod();
        t = new ConcreteMethod2();
        t.templateMethod();
    }
    public static void testStrategy()
    {
        StrategyContext sc = new StrategyContext(new StrategyImp2());
        sc.doAction();
        sc = new StrategyContext(new StrategyImpl1());
        sc.doAction();
    }
    public static void testCommand()
    {
        Commander c = new Commander(new com.behavior.command.Receiver(), "display", new Object[]{new String("My number is"), new Integer(5)});
        c.execution();
    }

    public static void testState()
    {
        StateContext sc = new StateContext(new ConcreteStateA());
        sc.operateChangeState();
        sc.operateChangeState();
    }
}
