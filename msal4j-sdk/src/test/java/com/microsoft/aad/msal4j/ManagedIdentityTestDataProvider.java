// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.aad.msal4j;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class ManagedIdentityTestDataProvider {
    private static final String CLIENT_ID = "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa";
    private static final String RESOURCE_ID = "/subscriptions/ffa4aaa2-4444-4444-5555-e3ccedd3d046/resourcegroups/UAMI_group/providers/Microsoft.ManagedIdentityClient/userAssignedIdentities/UAMI";

    public static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint,
                        ManagedIdentityTests.resource),
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint,
                        ManagedIdentityTests.resourceDefaultSuffix),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint,
                        ManagedIdentityTests.resource),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint,
                        ManagedIdentityTests.resourceDefaultSuffix),
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint,
                        ManagedIdentityTests.resource),
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint,
                        ManagedIdentityTests.resourceDefaultSuffix),
                Arguments.of(ManagedIdentitySourceType.IMDS, ManagedIdentityTests.IMDS_ENDPOINT,
                        ManagedIdentityTests.resource),
                Arguments.of(ManagedIdentitySourceType.IMDS, ManagedIdentityTests.IMDS_ENDPOINT,
                        ManagedIdentityTests.resourceDefaultSuffix),
                Arguments.of(ManagedIdentitySourceType.IMDS, null,
                        ManagedIdentityTests.resource),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint,
                        ManagedIdentityTests.resource),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint,
                        ManagedIdentityTests.resourceDefaultSuffix));
    }

    public static Stream<Arguments> createDataUserAssigned() {
        return Stream.of(
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint,
                        ManagedIdentityId.userAssignedClientId(CLIENT_ID)),
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint,
                        ManagedIdentityId.userAssignedResourceId(RESOURCE_ID)),
                Arguments.of(ManagedIdentitySourceType.IMDS, null,
                        ManagedIdentityId.userAssignedClientId(CLIENT_ID)),
                Arguments.of(ManagedIdentitySourceType.IMDS, null,
                        ManagedIdentityId.userAssignedResourceId(RESOURCE_ID)),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint,
                        ManagedIdentityId.userAssignedResourceId(CLIENT_ID)),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint,
                        ManagedIdentityId.userAssignedResourceId(RESOURCE_ID)));
    }

    public static Stream<Arguments> createDataUserAssignedNotSupported() {
        return Stream.of(
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint,
                        ManagedIdentityId.userAssignedClientId(CLIENT_ID)),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint,
                        ManagedIdentityId.userAssignedResourceId(RESOURCE_ID)),
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint,
                        ManagedIdentityId.userAssignedClientId(CLIENT_ID)),
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint,
                        ManagedIdentityId.userAssignedResourceId(RESOURCE_ID)));
    }

    public static Stream<Arguments> createDataWrongScope() {
        return Stream.of(
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint,
                        "user.read"),
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint,
                        "https://management.core.windows.net//user_impersonation"),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint,
                        "user.read"),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint,
                        "https://management.core.windows.net//user_impersonation"),
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint,
                        "user.read"),
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint,
                        "https://management.core.windows.net//user_impersonation"),
                Arguments.of(ManagedIdentitySourceType.IMDS, ManagedIdentityTests.IMDS_ENDPOINT,
                        "user.read"),
                Arguments.of(ManagedIdentitySourceType.IMDS, ManagedIdentityTests.IMDS_ENDPOINT,
                        "https://management.core.windows.net//user_impersonation"),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint,
                        "user.read"),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint,
                        "https://management.core.windows.net//user_impersonation"));
    }

    public static Stream<Arguments> createDataError() {
        return Stream.of(
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint),
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint),
                Arguments.of(ManagedIdentitySourceType.IMDS, ManagedIdentityTests.IMDS_ENDPOINT),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint));
    }

    public static Stream<Arguments> createDataGetSource() {
        return Stream.of(
                Arguments.of(ManagedIdentitySourceType.AZURE_ARC, ManagedIdentityTests.azureArcEndpoint, ManagedIdentitySourceType.AZURE_ARC),
                Arguments.of(ManagedIdentitySourceType.APP_SERVICE, ManagedIdentityTests.appServiceEndpoint, ManagedIdentitySourceType.APP_SERVICE),
                Arguments.of(ManagedIdentitySourceType.CLOUD_SHELL, ManagedIdentityTests.cloudShellEndpoint, ManagedIdentitySourceType.CLOUD_SHELL),
                Arguments.of(ManagedIdentitySourceType.IMDS, ManagedIdentityTests.IMDS_ENDPOINT, ManagedIdentitySourceType.DEFAULT_TO_IMDS),
                Arguments.of(ManagedIdentitySourceType.IMDS, "", ManagedIdentitySourceType.DEFAULT_TO_IMDS),
                Arguments.of(ManagedIdentitySourceType.SERVICE_FABRIC, ManagedIdentityTests.serviceFabricEndpoint, ManagedIdentitySourceType.SERVICE_FABRIC));
    }
}
