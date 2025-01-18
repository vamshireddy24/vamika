import axios from "axios";
import { API_BASE_URL, API_URLS } from "./constant"


export const getAllProducts = async (Id, typeId)=>{
    let url = API_BASE_URL + API_URLS.GET_PRODUCTS + `?categoryId=${Id}`;
    if(typeId){
        url = url + `&typeId=${typeId}`;
    }
    try{
        const result = await axios(url,{
            method:"GET"
        });
        return result?.data;

    }
    catch(err){
        console.error(err);
    }
}

export const getProductBySlug = async (slug)=>{
    const url = API_BASE_URL + API_URLS.GET_PRODUCTS + `?slug=${slug}`;
    try{
        const result = await axios(url,{
            method:"GET",
        });
        return result?.data?.[0];
    }
    catch(err){
        console.error(err);
    }
}
