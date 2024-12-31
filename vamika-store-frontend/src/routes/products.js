import content from '../data/content.json'

export const loadProductById = ({params}) => {
    const product = content?.products?.find((product)=> product?.id.toString() === params?.productId.toString());
    return {product};

}