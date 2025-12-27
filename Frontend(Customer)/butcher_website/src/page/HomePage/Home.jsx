import HomeImage from '../../assets/ThomasButcherTeamsImage.jpg';

// import icons from assets folder
import Rating from '../../assets/star.png';
import Google from '../../assets/google.png';

// import Home.css 
import './Home.css';

/**
 * Client Website Interface For Home Page Components
 * > description 
 *  - This is the Home.jsx react file that contain the content
 * > Create On 
 *  - Date: 25/12/2025
 *  - By: Anson Ling
 * > Update On 
 *  - Date: 26/12/2025
 *  - By: Anson Ling
 */
export default function Home() {

    return (
        <div className="homepage_ctr">
            <div className="homeleft_ctr">
                <h1 className='home_title'>
                    ORDER <span className='highlight'>FRESH</span> MEET AND COLLECT AT STORE
                </h1>
                <p className='home_content'>
                    Order fresh products online and 
                    collect them in store with zero hassle. 
                    Quality you can trust, ready when you are.
                </p>
                <button type="button" className='shopBtn'>
                    Shop Here →
                </button>

                <div className="rate_ctr">
                    <div className="rating_icons">
                        <img src={Rating} alt="rateicons" className='rateicons' />
                        <img src={Rating} alt="rateicons" className='rateicons' />
                        <img src={Rating} alt="rateicons" className='rateicons' />
                        <img src={Rating} alt="rateicons" className='rateicons' />
                        <img src={Rating} alt="rateicons" className='rateicons' />
                    </div>
                    <span className='rating_ctr'>5/5 . From 55 Reviews</span>
                    <img src={Google} alt="googleicons" className='googleicons' />
                </div>
            </div>
            <img src={HomeImage} alt="content_image" className='content_image' />
        </div>
    );
}