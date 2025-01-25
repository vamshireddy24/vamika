import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ProductListPage from "./pages/ProductListPage/ProductListPage";
import ShopApplicatiponWrapper from "./pages/ShopApplicatiponWrapper";
import ProductDetails from "./pages/ProductDetailPage/ProductDetails";
import { loadProductBySlug } from "./routes/products";


export const router = createBrowserRouter([
    {
      path: "/",
      element: <ShopApplicatiponWrapper />,
      children:[
        {
            path: "/",
            element: <App />
        },
        {
            path:"/women",
            element:<ProductListPage categoryType={'WOMEN'}/>
        },
        {
            path:"/men",
            element:<ProductListPage categoryType={'MEN'}/>
        },
        {
          path:"/kids",
          element:<ProductListPage categoryType={'KIDS'}/>
        },
        {
          path:"/product/:slug",
          loader: loadProductBySlug,
          element:<ProductDetails/>
        }
      ]
    },
]);