import { checkIsSelected } from "./helpers";
import Productcard from "./ProductCard";
import { Product } from "./types";

type Props = {
    products: Product[];
    selectedProducts: Product[];
    onSelectProduct: (product: Product) => void;
}

function ProductsList({ products, onSelectProduct, selectedProducts }: Props) {

    return (
        <div className="orders-list-container">
            <div className="orders-list-items">
                {products.map(product => (
                    <Productcard
                        key={product.id}
                        product={product}
                        onSelectProduct={onSelectProduct}
                        isSelected={checkIsSelected(selectedProducts, product)}
                    />

                ))}

            </div>
        </div>
    )

}

export default ProductsList;