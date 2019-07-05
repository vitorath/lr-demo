import React, { useState, useEffect } from 'react';
import api from './services/api';

import PagenadedTable from './components/TablePagination';

import './App.css';

const App = props => {
  const [userData, setUserData] = useState({
      data: [], 
      pageable: {
        page: 0, 
        rowsPerPage: 10
      } 
    });

  useEffect(() => {
    console.log('useEffect');
    const uri = `/users?size=${userData.pageable.rowsPerPage}`;
    api.get(uri).then((response) => {
      setUserData({...userData, data: response.data});
      console.log('updateUsers');
    }).catch((error => {
      console.log(error);
    }));
  }, [])

  const changePageHandler = (event, newPage) => {
    console.log(`/users?page=${newPage}&size=${userData.pageable.rowsPerPage}`);
    const uri = `/users?page=${newPage}&size=${userData.pageable.rowsPerPage}`; 
    api.get(uri).then((response) => {
      let pageable = userData.pageable;
      pageable.page = newPage;
      setUserData({...userData, data: response.data, pageable: pageable});
      console.log('updateUsers');
    }).catch((error => {
      console.log(error);
    }));
  }

  const changeRowsPerPageHandler = (event) => {
    console.log(`/users?page=${userData.pageable.page}&size=${+event.target.value}`)
    const uri = `/users?page=${userData.pageable.page}&size=${+event.target.value}`;
    api.get(uri).then((response) => {
      let pageable = userData.pageable;
      pageable.rowsPerPage = +event.target.value;
      setUserData({...userData, data: response.data, pageable: pageable});
      console.log('updateUsers');
    }).catch((error => {
      console.log(error);
    }));
  }

  let contentUserDataPage = null
  if (userData.data.length === 0) {
    contentUserDataPage = <p>Loading...</p>
  } else {
    console.log('App', userData)
    contentUserDataPage = (
        <PagenadedTable 
          data={userData.data.content}
          count={userData.data.totalElements} 
          rowsPerPage={userData.pageable.rowsPerPage}
          page={userData.pageable.page}
          changePageHandler={changePageHandler}
          changeRowsPerPageHandler={changeRowsPerPageHandler} />
    )
  }

  return (
    <React.Fragment>
      <section id="pagination-table" className="table">
        <header className="header">
          <h1 className="title">Tabela paginada os usuários</h1>
        </header>
        {contentUserDataPage}
      </section>
    </React.Fragment>
  )
}

export default App;
