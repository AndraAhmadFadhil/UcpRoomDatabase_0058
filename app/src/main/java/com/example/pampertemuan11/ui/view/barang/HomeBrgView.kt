package com.example.pampertemuan11.ui.view.barang

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cekcek.ui.customwidget.TopAppBar
import com.example.pampertemuan11.data.entity.Barang
import com.example.pampertemuan11.ui.viewmodel.HomeBrgUiState
import com.example.pampertemuan11.ui.viewmodel.HomeBrgViewModel
import com.example.pampertemuan11.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeBrgView(
    viewModel: HomeBrgViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onBack: () -> Unit,
    onDetailClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    Scaffold (
        modifier = modifier.background(color = Color.Cyan),
        topBar = {
            TopAppBar(
                onBack = onBack,
                judul = "Daftar Barang",
                showBackButton = true,

                )
        }
    ){innerPadding ->
        val homeBrgUiState by viewModel.homeBrgUiState.collectAsState()

        BodyHomeBarView(
            homeBrgUiState = homeBrgUiState,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BodyHomeBarView(
    homeBrgUiState: HomeBrgUiState,
    onClick: (String) -> Unit = { },
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    when {
        homeBrgUiState.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        homeBrgUiState.isError -> {
            LaunchedEffect (homeBrgUiState.errorMessage){
                homeBrgUiState.errorMessage?.let{ message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message)
                    }
                }
            }
        }

        homeBrgUiState.listBrg.isEmpty() -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Tidak ada data barang.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        else -> {
            ListBarang(
                listBrg = homeBrgUiState.listBrg,
                onClick = {
                    onClick(it)
                    println(
                        it
                    )
                },
                modifier = modifier

            )
        }
    }
}

@Composable
fun ListBarang(
    listBrg: List<Barang>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = { }
){
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = listBrg,
            itemContent = { brg ->
                CardBar(
                    brg = brg,
                    onClick = {onClick(brg.nama)}
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardBar(
    brg: Barang,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){

    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color(0xFFE0F7FA))
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Shopping Cart", tint = Color(0xFF00796B))
            Spacer(modifier = Modifier.padding(8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = brg.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF004D40)
                )
                Text(
                    text = "Stock: ${brg.stok}",
                    fontSize = 14.sp,
                    color = Color(0xFF00796B)
                )
                Text(
                    text = "Supplier: ${brg.namaSupplier}",
                    fontSize = 14.sp,
                    color = Color(0xFF004D40)
                )
                Text(
                    text = "Price: ${brg.harga}",
                    fontSize = 14.sp,
                    color = Color(0xFF00796B)
                )
            }
        }
    }
}