import React from 'react';

import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import TablePagination from '@material-ui/core/TablePagination';

const PagenadedTable = props => {

  const emptyRows = props.rowsPerPage - Math.min(props.rowsPerPage, props.data.length);
  console.log(`empty: ${emptyRows} rowsPerPage: ${props.rowsPerPage}, v: ${props.data.length - props.page * props.rowsPerPage}`, );
  return (
    <Paper>
    <Table>
      <TableHead>
        <TableRow>
          <TableCell align="left">Nome</TableCell>
          <TableCell align="left">Idade</TableCell>
          <TableCell align="left">Sexo</TableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {props.data.map(user => (
          <TableRow key={user.id}>
            <TableCell>{user.name}</TableCell>
            <TableCell>{user.age}</TableCell>
            <TableCell>{user.isFemale ? 'F' : 'M'}</TableCell>
          </TableRow>
        ))}
        {emptyRows > 0 && (
          <TableRow style={{height: 49 * emptyRows}}>
            <TableCell colSpan={6}/>
          </TableRow>
        )}
      </TableBody>
    </Table>
    <TablePagination 
        component="div"
        rowsPerPageOptions={[5, 10,500]}
        count={props.count}
        rowsPerPage={props.rowsPerPage}
        page={props.page}
        onChangePage={props.changePageHandler}
        onChangeRowsPerPage={props.changeRowsPerPageHandler} />
    </Paper>
  );
}

export default PagenadedTable;