package com.example.ucp_2pam.ui.Navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp_2pam.ui.View.Barang.DetailBrgView
import com.example.ucp_2pam.ui.View.Barang.InsertBrgView
import com.example.ucp_2pam.ui.View.Barang.UpdateBrgView
import com.example.ucp_2pam.ui.View.Home
import com.example.ucp_2pam.ui.View.Suplier.HomeSplView
import com.example.ucp_2pam.ui.View.Suplier.InsertSplView
import com.example.ucp_2pam.view.barang.HomeBrgView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    ) {
        composable(
            route = DestinasiHome.route
        ) {
            Home (
                onBarangClick = { navController.navigate(DestinasiHomeBrg.route) },
                onTambahBarangClick = { navController.navigate(DestinasiInsertBrg.route) },
                onSuplierClick = { navController.navigate(DestinasiHomeSpl.route) },
                onTambahSuplierClick = { navController.navigate(DestinasiInsertSpl.route) },
            )
        }
        composable(
            route = DestinasiHomeBrg.route
        ){
            HomeBrgView(
                onDetailBrgClick = {idBarang ->
                    navController.navigate("${DestinasiDetailBrg.route}/$idBarang")
                    println("PengelolaHalaman: idBarang= $idBarang")
                },
                onAddBrgClick = {navController.navigate(DestinasiInsertBrg.route)},
                onBack = {navController.popBackStack()},
                modifier = Modifier
            )
        }
        composable(
            route = DestinasiHomeSpl.route
        ){
            HomeSplView(
                onBack = {navController.popBackStack()},
                modifier = Modifier
            )
        }
        composable(
            route = DestinasiInsertBrg.route
        ){
            InsertBrgView(
                onBack = {navController.popBackStack()},
                onNavigate = { },
                modifier = Modifier
            )
        }
        composable(
            DestinasiDetailBrg.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetailBrg.idBarang){
                    type = NavType.StringType
                }
            )
        ){
            val id = it.arguments?.getString(DestinasiDetailBrg.idBarang)
            id?.let { id ->
                DetailBrgView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = Modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )

            }
        }
        composable(
            DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.idBarang){
                    type = NavType.StringType
                }
            )
        ){
            UpdateBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = Modifier,
            )
        }
        composable(
            route = DestinasiInsertSpl.route
        ){
            InsertSplView(
                onBack = {navController.popBackStack()},
                onNavigate = { },
                modifier = Modifier
            )
        }
    }
}