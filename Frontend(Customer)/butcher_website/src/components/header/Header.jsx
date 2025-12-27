// import the logo from assets folder
import Logo from '../../assets/tempButcherLogo.png';
import WishlistIcons from '../../assets/wishlist.png';
import OrderIcons from '../../assets/order.png';

// import the css
import './Header.css';

/**
 * Client Website Interface For Header Components
 * > description 
 *  - This is the Header.jsx react file that will contain the section for each page
 *  - Including all the top navigators
 * > Create On 
 *  - Date: 25/12/2025
 *  - By: Anson Ling
 */
export default function Header() {

    return (
        <header className="header_container">
            <img src={Logo} className='logoIcons' id="logo" alt="logo"/>
            <ul className='menu'>
                <li><a href="#home">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#onlineshop">Online Shop</a></li>
                <li><a href="#contact">Contact Us</a></li>
            </ul>
            <div className="left_header">
                <a href="http://"><img src={WishlistIcons} className='icons' id="WishlistIcons" alt="WishlistIcons" /></a>
                <a href="http://"><img src={OrderIcons} className='icons' id="OrderIcons" alt="OrderIcons" /></a>
                {
                    <button type="button">
                        Login
                    </button>
                }
            </div>
        </header>
    );
}