
public class sf {
    public static Product createProduct(String type){
        if(type == "A"){
            return new pa();
        }else {
            return new pb();
        }
    }
    public static void main(String[] args) {
        Product product = createProduct("A");
        product.print();
    }

}
abstract class Product{
    public abstract void print();
}
class pa extends Product{

    @Override
    public void print() {
        System.out.println("pa");
    }
}
class pb extends Product{

    @Override
    public void print() {
        System.out.println("pb");
    }
}
