// import image from assets
import shop from '../../assets/butchershopimage.webp';

// import components 
import Card from './Components/About.Card.jsx';

// import css
import './About.css';

/**
 * Client Website Interface For About Page
 * > description 
 *  - This is the About.jsx react file for about page content
 * > Create On 
 *  - Date: 25/12/2025
 *  - By: Anson Ling
 * > Update On 
 *  - Date: 26/12/2025
 *  - By: Anson Ling
 */
export default function About() {


    return (
        <div className="about_ctr" >
            <div className="about_content">
                <h1 className='about_title'>About Thomas Hayes Butchers</h1>
                <div className="about_card_ctr">
                    <img src={shop} alt="shopImg" className='shopImg' />
                    <article>
                        <span className='highlight'>Thomas Hayes Butchers</span> is a traditional 
                        Irish butcher shop rooted in local community values and a commitment to quality produce. 
                        Located on a well-established neighbourhood street, the shop has long served 
                        local customers who value freshness, craftsmanship, and personal service.
                    </article>
                </div>
            </div>
            <div className="about_content">
                <h1 className='about_title'>What We Offer</h1>
                <div className="cards_ctr">
                    <Card 
                        content={"Fresh beef, lamb, pork, and poultry" }
                    />
                    <Card 
                        content={"Traditional Irish cuts and preparations"} 
                    />
                    <Card 
                        content={"Custom orders and portioning"} 
                    />
                    <Card 
                        content={"Friendly, knowledgeable recommendations" }
                    />
                </div>
            </div>
        </div>
    );
}