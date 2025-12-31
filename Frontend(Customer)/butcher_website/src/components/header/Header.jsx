

// import the logo from assets folder
import Logo from '../../assets/tempButcherLogo.png';
import WishlistIcons from '../../assets/wishlist.png';
import OrderIcons from '../../assets/order.png';
import User from '../../assets/userAvatar.png';

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

    const isLogin = false;

    return (
        <header className="header_container">
            <img src={Logo} className='logoIcons' id="logo" alt="logo"/>
            <ul className='menu'>
                <li><a href="#home" className='navigator' >Home</a></li>
                <li><a href="#about" className='navigator' >About</a></li>
                <li><a href="#onlineshop" className='navigator' >Online Shop</a></li>
                <li><a href="#contact" className='navigator' >Contact Us</a></li>
            </ul>
            <div className="left_header">
                <div className="wishlist_ctr">
                    <a href="http://"><img src={WishlistIcons} className='icons' id="WishlistIcons" alt="WishlistIcons" /></a>
                    <span>Wishlist</span>
                </div>
                <div className="order_ctr">
                    <a href="http://"><img src={OrderIcons} className='icons' id="OrderIcons" alt="OrderIcons" /></a>
                    <span>Orders</span>
                </div>
                {
                    isLogin === false ? (
                        <button type="button" className='loginBtn'>
                            Login
                        </button>
                    ) : (
                        <img src={User} alt="icons" className='icons' />
                    )
                }
            </div>
        </header>
    );
}