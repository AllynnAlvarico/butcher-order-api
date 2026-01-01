import axios from 'axios'
import { useEffect } from 'react';


export default function OnlineShop() {

    useEffect(() => {
        axios.get(``)
        .then((res) => {
            res
        })
    }, [])

    return (
        <div className="onlineshop_ctr">
            <div className="onlineshop_category_ctr">
                <div className="title_ctr">
                    Fresh & Latest Meats Option Here=
                </div>
                <div className="categories_ctr">
                    <button type="button">All</button>
                    <button type="button">Beef</button>
                    <button type="button">Chicken</button>
                    <button type="button">Turkey</button>
                </div>
            </div>
            <div className="products_ctr">

            </div>
        </div>
    );
}