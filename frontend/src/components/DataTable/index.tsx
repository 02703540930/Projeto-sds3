import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/request";

const DataTable = () => {

    //configuração da paginacao que vem lá da requisicao postman e criada no type.ts
    const [page, setPage] = useState<SalePage>({
        first: true,
        last: true,
        number: 0,
        totalElements: 0,
        totalPages: 0,
    });

    //usado para executar somente quando a pagina carregar, fara apenas uma execucao
    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=10&size=10&sort=date,desc`)
            .then(response => {
                setPage(response.data);          //response.data eh a resposta da requisicao entre crases. o setPage está no formato da resposta
                // e o SalePage contem os campos identicos do banco de dados. monstrando assim na pagina os dados vindos do banco.
            });
    }, []);

    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map(item => (    //busca dentro do content que sao todos os registos do detalhe. tr com key id do registro pq o rect exige uma chave para cada item de uma coleção de dados
                        //<tr>
                        <tr key={item.id}>
                            <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                            <td>{item.seller.name}</td>
                            <td>{item.visited}</td>
                            <td>{item.deals}</td>
                            <td>{item.amount.toFixed(2)}</td>
                        </tr>
                    ))}

                </tbody>
            </table>
        </div>

    );
}

export default DataTable;