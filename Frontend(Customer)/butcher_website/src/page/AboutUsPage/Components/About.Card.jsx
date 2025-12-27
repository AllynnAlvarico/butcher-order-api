// import css
import './Card.css';

/**
 * Client Website Interface For About Card Components
 * > description 
 *  - This is the About.Card.jsx react file for card components
 * > Create On 
 *  - Date: 26/12/2025
 *  - By: Anson Ling
 */

export default function Card({content}) {
    return (
        <div className="card_ctr">
            <span className='symbol'>✔</span> {content}
        </div>
    );
}