import React from 'react';

import IconButton from '@material-ui/core/IconButton';
import FirstPageIcon from '@material-ui/icons/FirstPage';
import LastPageIcon  from '@material-ui/icons/LastPage';
import KeyboardArrowRight  from '@material-ui/icons/KeyboardArrowRight';
import KeyboardArrowLeft from '@material-ui/icons/KeyboardArrowLeft';

// import tablePaginationActions 

// const tablePaginationActions = ({count, page, rowsPerPage, onChangePage, ...props}) => {

//   const firstPageButtonClickHandler = (event) => {
//     onChangePage(event, 0);
//   };

//   const backButtonClickHandler = (event) => {
//     onChangePage(event, page - 1);
//   };

//   const nextButtonClickHandler = (event) => {
//     onChangePage(event, page + 1);
//   };

//   const lastPageButtonClickHandler = (event) => {
//     onChangePage(event, Math.ceil(count/rowsPerPage) - 1);
//   };

//   return (
//     <div className="">
//       <IconButton 
//         onClick={firstPageButtonClickHandler}
//         disabled={page === 0}
//         aria-label="First Page">
//           <FirstPageIcon />
//       </IconButton>
          
//       <IconButton
//         onClick={backButtonClickHandler}
//         disabled={page === 0}
//         aria-label="Previous Page">
//           <KeyboardArrowLeft />
//       </IconButton>

//       <IconButton
//         onClick={nextButtonClickHandler}
//         disabled={page >= Math.ceil(count / rowsPerPage) - 1}
//         aria-label="Next Page">
//           <KeyboardArrowRight />
//       </IconButton>

//       <IconButton
//         onClick={lastPageButtonClickHandler}
//         disabled={page >= Math.ceil(count / rowsPerPage) - 1}
//         aria-label="Last Page">
//           <LastPageIcon />
//       </IconButton>
//     </div>
//   );

// }

// export default tablePaginationActions;