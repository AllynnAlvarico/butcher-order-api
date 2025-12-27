import Home from './HomePage/Home.jsx'
import About from './AboutUsPage/About.jsx'
import OnlineShop from './OnlineShopPage/OnlineShop.jsx'
import Contact from './ContactUsPage/Contact.jsx'

import './Main.css';

/**
 * Client Website Interface For Main Page
 * > description 
 *  - This is the Main.jsx react file that will contain the section for each page
 *  - Including Home, About Us, Online Shop, Contact Us
 * > Create On 
 *  - Date: 25/12/2025
 *  - By: Anson Ling
 */
export default function Main() {

    return (
        <div>
            <section id='home'>
                <Home />
            </section>
            <section id='about'>
                <About />
            </section>
            <section id='onlineshop'>
                <OnlineShop />
            </section>
            <section id='contact'>
                <Contact />
            </section>
        </div>
    );
}