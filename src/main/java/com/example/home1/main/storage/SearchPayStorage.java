
package com.example.home1.main.storage;

import com.example.home1.pays.pay.dto.PayCalcDto;
import com.example.home1.pays.pay.dto.PayNoDateDto;
import com.example.home1.pays.pay.dto.PayTotallDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class SearchPayStorage {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public List<PayCalcDto> calcPays(Integer year) {
        String sql = "select category_pay1,\n" +
                "       /*sum_pay,*/\n" +
                "       max( case when month1='1' then sum_pay end ) as yan,\n" +
                "       max( case when month1='2' then sum_pay end ) as fev,\n" +
                "       max( case when month1='3' then sum_pay end ) as mart,\n" +
                "       max( case when month1='4' then sum_pay end ) as apr,\n" +
                "       max( case when month1='5' then sum_pay end ) as may,\n" +
                "       max( case when month1='6' then sum_pay end ) as yun,\n" +
                "       max( case when month1='7' then sum_pay end ) as yul,\n" +
                "       max( case when month1='8' then sum_pay end ) as avgu,\n" +
                "       max( case when month1='9' then sum_pay end ) as sept,\n" +
                "       max( case when month1='10' then sum_pay end ) as oct,\n" +
                "       max( case when month1='11' then sum_pay end ) as nov,\n" +
                "       max( case when month1='12' then sum_pay end ) as decb," +
                " sum(sum_pay) as totall" +
                "\n" +
                "from (SELECT CP.CATEGORY_PAY as category_pay1, sum(PAY) as sum_pay, MONTH(TIME_PAY) as month1\n" +
                "      FROM PAYS\n" +
                "               join CATEGORY_PAYS CP on CP.ID = PAYS.CATEGORY_PAY_ID\n" +
                /*"      WHERE YEAR(TIME_PAY) = 2023\n" +*/
                "      WHERE YEAR(TIME_PAY) = ?\n" +
                "      GROUP BY month1, category_pay1)\n" +
                "group by category_pay1;";

        List<PayCalcDto> payCalcDtos = jdbcTemplate.query(sql, ((rs, rowNum) ->
                (new PayCalcDto(rs.getString("category_pay1"),
                        rs.getInt("yan"),
                        rs.getInt("fev"),
                        rs.getInt("mart"),
                        rs.getInt("apr"),
                        rs.getInt("may"),
                        rs.getInt("yun"),
                        rs.getInt("yul"),
                        rs.getInt("avgu"),
                        rs.getInt("sept"),
                        rs.getInt("oct"),
                        rs.getInt("nov"),
                        rs.getInt("decb"),
                        rs.getInt("totall")
                ))), year);
        return payCalcDtos;
    }

    public List<PayTotallDto> calcYear(Integer year) {
        List<PayTotallDto> payTotallDtos = new ArrayList<>();
        String sql = "select month1,\n" +
                "       pr.month2,\n" +
                "       max(case when c_pay = '1' then sum_pay end) as main,\n" +
                "       max(case when c_pay = '2' then sum_pay end) as other,\n" +
                "       max(case when c_pay = '3' then sum_pay end) as not_main,\n" +
                "       sum(sum_pay)                                as totall,\n" +
                "       pr.profit_sum                         as profit\n" +
                "from (SELECT MONTH(TIME_PAY) as month1, sum(PAY) as sum_pay, vcp.ID as c_pay\n" +
                "      FROM PAYS\n" +
                "               join CATEGORY_PAYS CP on CP.ID = PAYS.CATEGORY_PAY_ID\n" +
                "               join VID_CATEGORY_PAYS VCP on VCP.ID = CP.VID_CATEGORY_PAY_ID\n" +
                "      WHERE YEAR(TIME_PAY) = ?\n" +
                "      group by c_pay, month1)\n" +
                "         left join (select sum(PROFIT) as profit_sum, MONTH(TIME_PROFIT) as month2\n" +
                "                    from PROFITS\n" +
                "                    group by month2) as PR on pr.month2 = month1\n" +
                "group by  month1, pr.month2\n" +
                ";";

        payTotallDtos = jdbcTemplate.query(sql, (rs, rowNum) -> (
                new PayTotallDto(
                        rs.getInt("month1"),
                        rs.getInt("main"),
                        rs.getInt("other"),
                        rs.getInt("not_main"),
                        rs.getInt("totall"),
                        rs.getInt("profit")
                )), year);
        return payTotallDtos;
    }

    public List<PayNoDateDto> findPays(LocalDate start, LocalDate end) {
        //public void findPays(LocalDate start, LocalDate end) {
        String sql = String.format("" +
                        "select p.CATEGORY_PAY_ID, sum(p.PAY) as pay from PAYS as p where TIME_PAY between '%s' and '%s' group by p.CATEGORY_PAY_ID"
                , start, end);
        System.out.println(sql);
        List<PayNoDateDto> payNoDateDtoList = jdbcTemplate.query(sql, ((rs, rowNum) ->
                (getCategoryById(rs.getLong("category_id"), rs.getInt("pay")))));
        System.out.println(payNoDateDtoList);
        return payNoDateDtoList;
    }

    private PayNoDateDto getCategoryById(Long id, Integer pay) {
        PayNoDateDto payNoDateDto = new PayNoDateDto();
        SqlRowSet genreSet = jdbcTemplate.queryForRowSet("SELECT * FROM categories WHERE id=?", id);
        while (genreSet.next()) {
            payNoDateDto.setCategoryPay(genreSet.getString("category"));
            payNoDateDto.setVidCategoryPay(genreSet.getString("vidCategoryPay"));
            payNoDateDto.setPay(pay);
            System.out.print(genreSet.getString("category") + " ");
            System.out.println(genreSet.getString("impotance"));
        }
        return payNoDateDto;
    }
}

