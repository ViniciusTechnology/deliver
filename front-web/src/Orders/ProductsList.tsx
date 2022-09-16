import Productcard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products: Product[];
}

function ProductsList({products}:Props) {

    return (
        <div className="class-list-container">
            <div className="orders-list-items">
                {products.map(product =>(
                    <Productcard key={product.id} product ={product}/>
                ))}
                
            </div>
        </div>
    )

}

export default ProductsList;