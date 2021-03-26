public class Receipt {



	public Receipt(Product[] cart){

		System.out.printf("%10s%12s%10s%15s\n","Item","Code","Cost","After Tax");
		System.out.println("================================================");

		double totalCost =0;
		for(Product product: cart){
			double afterTax =product.getCost()+product.getCost()*Product.getTax();
			totalCost+=afterTax;

			System.out.printf("%10s%12s%10.2f%15.2f\n",
					product.getName(),
					product.getCode(),
					product.getCost(),
					afterTax);

		}
		System.out.println("================================================");
		System.out.printf("%47.2f",totalCost);

	}

	public static void main(String[] args) {

		Product[] products = new Product[3];

		products[0] = new Product("Bread","BL 4007",3.99);
		products[1] = new Product("Eggs","JE 1972",2.99);
		products[2] = new Product("Lasagna","PM 1921",11.99);

		Receipt receipt = new Receipt(products);

	}
}
